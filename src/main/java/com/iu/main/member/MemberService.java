package com.iu.main.member;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	// 회원수정
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	
	// Join
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session)throws Exception{
		// 파일의 정보를 이용해서 HDD(하드디스크)에 파일 저장
		
		// 1. 어디에 저장??
		String path="/resources/upload/member";
		
		// 2. 실제 경로 알아오기 (tomcat의 Application(내장객체)사용)
		// jsp : application
		// java : ServletContext
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);  
		
		// 3. 위 경로로 file 생성
		File file = new File(realPath);
		if(!file.exists()) {	// file.exists()==false : file 존재하지 않을 때
			file.mkdirs();
		}
		
		// Calendar의 getInstance()를 통해 중복되지 않는 파일이름 생성
		Calendar ca = Calendar.getInstance();
		long result = ca.getTimeInMillis();
		// file = 경로, result(시분초)_파일명
		file = new File(file, result+"_"+multipartFile.getOriginalFilename());
		
		
		// file = 파일(realPath)경로로 실제파일이름을 넣는 정보를 갖는다.
		file = new File(file, multipartFile.getOriginalFilename());
		
		// 4. 파일을 저장
		// 1번 방법. Spring에서 제공하는 API FileCopyUtils copy메서드
		// 이진데이터를 갖는 multipartFile에서 getBytes(이진데이터를 담는) method 사용
		// 받은 소스(왼)를 폴더(오,new File(file, multipartFile.getOriginalFilename()))로 저장하자
		// 받은 소스: 회원가입시 파일추가하면 해당 파일을 이진데이터로 나눠서 Server로 보냄
		//         이런 나눠진 데이터를 배열로 받아 조립하는 과정을 실행하는 메서드
		//FileCopyUtils.copy(multipartFile.getBytes(), file);  
		
		// 2번 방법. MultipartFile의 transferTo 메서드
		multipartFile.transferTo(file);
		
		return 0; //memberDAO.setJoin(memberDTO);
	}
}
