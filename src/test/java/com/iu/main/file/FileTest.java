package com.iu.main.file;

import java.io.File;

import org.junit.Test;

import com.iu.main.Mytest;

public class FileTest extends Mytest {
	
	@Test
	public void test() {
		// File 경로를 갖는 객체 생성
		File file = new File("C:\\study\\study.txt");
		file = new File("C:\\study","study.txt");	// 위 코드 동일
		System.out.println(file.exists());	// true
		System.out.println(file.isFile());	// true
		
		
		file = new File("C:\\study");
		System.out.println(file.exists());	// true
		System.out.println(file.isFile());	// false
		System.out.println(file.isDirectory());	// true
		System.out.println("=====================");
		
		file = new File(file, "ex");	// file(C:\\study) 경로의 ex위치
		System.out.println(file.exists());	// true
		System.out.println(file.isDirectory());	// true
		
		file.delete();
		
		// delete : study file 
		file = new File("C:\\study\\study.txt");
		file.delete();
		
		file = new File("C:\\study");
		//file.delete(); -> false = 폴더 안에 파일 존재할 시 지워지지 않는다.
		
		// folder안에 file List 출력
		String [] list = file.list();
		// 향상된 for 문
		// for(Collection에서 모은타입:변수명 = Collection:변수명) Collention : 하나의 파일을 String으로 모았기 때문에 
		for(String str:list) {
			System.out.println(str);	// Test.class , Test.java 파일 리스트출력
		}
		
		
		// mkdir : 디렉토리 생성
		file = new File(file, "t1");  // C:\\study\\t1 경로로 파일 생성
		file.mkdir();
		
		file = new File(file, "sub1\\sub2");	// C:\\study\\t1\\sub1\\sub2 경로로 파일 생성
		//file.mkdir();	// sub1 폴더가 없어 생성X, 중간파일 없으면 생성불가능
		file.mkdirs();	// 중간에 없는 파일도 만들어서 생성O
	}
}
