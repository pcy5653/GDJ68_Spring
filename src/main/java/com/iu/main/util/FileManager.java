package com.iu.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.member.MemberDTO;

@Component
public class FileManager {
	
	
	// fileSave
	public String fileSave(String path, HttpSession session, MultipartFile multipartFile) throws Exception {
		// 1. 어디에 저장?
		// String path="/resources/upload/member/";	=> 매개변수 받기
		
		// 2. 실제 경로 알아오기 (tomcat의 Application(내장객체)사용)
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
		
		return uId; //Service에서 fileName 넣기 위해
	}
}
