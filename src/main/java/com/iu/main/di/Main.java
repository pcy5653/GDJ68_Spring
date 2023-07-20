package com.iu.main.di;

public class Main {

	public static void main(String[] args) {
		// 로봇을 생성 = 객체 생성(변수선언(Robot robot) = 객체생성(new Robot();))
		Robot robot = new Robot();
		
		// 로봇의 팔을 출력하자(get=가져오다)
		// 로봇은 팔을 가지고 일하낟 -> 로봇은 팔에 대해 의존적 (dependency) -> 팔 객체 생성
		
		// * dependency Injection (의존성을 주입한다.)
		// * 1.생성자에서 주입 2.method(setter)에서 주입
		Arm arm = new Arm();
		
		// 1. 생성자에서 주입
		// Robot robot = new Robot(arm);
		// 2. method 주입
		robot.setArm(arm);
		System.out.println(robot.getArm());
		
		
	}

}
