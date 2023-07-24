package com.iu.main;
//junit : Tomcat 실행 하지 않고 DAO TEST 실행하기 위함
// database-context.xml 읽지 못함, @ContextConfiguration으로 보이는 경로 지정(** = 폴더 및 파일 전부)
// abstract : 상속받아 사용

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iu.main.bankBook.BankBookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class Mytest {
	
//	@Autowired
//	private BankBookDAO bankBookDAO;
//	
//	@Test
//	public void deleteTest()throws Exception {
//		int result = bankBookDAO.setDelete(41L);
//		
//		// result값이 0이 아니길 희망한다.
//		assertNotEquals(0, result);
//	}

}
