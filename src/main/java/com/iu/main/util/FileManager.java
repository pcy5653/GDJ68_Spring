package com.iu.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.file.FileDTO;
import com.iu.main.member.MemberDTO;

@Component
public class FileManager extends AbstractView {
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("FileManager");
		// notice
		String b = (String)model.get("board");
		
		FileDTO fileDTO = (FileDTO)model.get("file");
		
		// 1. 파일 경로 준비
		String path = "/resources/upload/"+b;
		path = request.getSession().getServletContext().getRealPath(path);
		
		// 2. File 객체 생성
		// file = 어느경로(path), 어떤이름 (fileDTO.getFileName())
		File file = new File(path, fileDTO.getFileName());
		
		// 3. 총 파일을 크기 설정
		// 다운로드 시, 크기 출력(몇 % 남았는지 공지)
		response.setContentLength((int)file.length());
		
		
		// 4. 다운로드때, 이름 설정 (파일의 오리지널로 하고 한글 출력)
		String downName = fileDTO.getOriginalName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		
		// 5. Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 6. 전송 <is -> os>
		// 입력
		FileInputStream is = new FileInputStream(file);
		// 출력
		OutputStream os = response.getOutputStream();
		
		// 응답으로 is로 들어오고 os로 나가는 것을 전달하라.
		FileCopyUtils.copy(is, os);
		
		// 7. 자원 해제(연결된 역순으로 끊기 os -> is)
		os.close();
		is.close();
	}

	
	// fileSave
	public String fileSave(String path, HttpSession session, MultipartFile multipartFile) throws Exception {
		// 1. 어디에 저장?
		// String path="/resources/upload/member/";	=> 매개변수 받기
		
		// 2. 실제 경로 알아오기 (tomcat의 Application(내장객체)사용 > session을 사용하기 위함)
		// jsp : application
		// java : ServletContext
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		
		// 3. 위 경로로 file 생성 -> mkdirs 여러개 파일 생성
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 4. 어떤 이름으로 저장?? (시간 vs API) file 경로로 해당이름저장
		String uId = UUID.randomUUID().toString();	
		uId = uId+"_"+multipartFile.getOriginalFilename();	// MemberFile의 fileName 대입하기 위함
		file = new File(file, uId);
		
		// 5. 파일 저장
		multipartFile.transferTo(file);
		
		return uId; //Service에서 각각의 fileName 넣기 위해
	}
	
	
	// fileDelete : fileName을 받아야 하기 때문에 부모인 FileDTO 매개변수
	public boolean fileDelete(FileDTO fileDTO, String path, HttpSession session)throws Exception {
		// 1. 어디폴더? : 삭제할 폴더의 실제 경로
		path = session.getServletContext().getRealPath(path);
		
		// 2. 파일의 이름으로 경로 설정
		File file = new File(path, fileDTO.getFileName());
		
		// 3. 삭제 (ture | false)
		return file.delete();
	}
}
