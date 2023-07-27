package com.iu.main.file;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.iu.main.Mytest;

public class CalendarTest extends Mytest{

	@Test
	public void test() {
		// 1. Random 사용
		Calendar ca = Calendar.getInstance();
		System.out.println(ca);
		System.out.println(ca.getTime());
		
		System.out.println(ca.get(Calendar.YEAR));	// 20232
		System.out.println(ca.get(Calendar.DATE));	// 27
		System.out.println(ca.get(Calendar.MONTH));	// 6출력, MONTH만 +1로 생각
		
		ca.set(Calendar.YEAR, 1998);
		ca.set(Calendar.MONTH, 0);  // 원하는 MONTH-1 작성
		System.out.println(ca.getTime());
		
		
		System.out.println("=================");
		ca = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		ca2.set(2023, 6, 27, 18, 20);
		
		long l1 = ca.getTimeInMillis();
		long l2 = ca2.getTimeInMillis();
		long result = l2 - l1;
		System.out.println(result/(1000*60));  // 초 : 1000 | 분 : 1000*60 | 시간 : 1000*60*60 | 일 : 1000*60*60*24
	}

}
