package com.iu.main.di;

public class Robot  {
	
	private String name;
	
	// 로봇이 팔을 가지고 있기에 멤버변수로 사용.
	// 상속X
	private Arm arm;
	
	public Robot() {
		// 1.생성자에서 주입
		//결합도가 높다(강하다) => 로봇 안에 Arm의 객체 생성
		this.arm = new Arm();
	}
	
	public Robot(Arm arm) {
		// 1.생성자에서 주입
		// 결합도가 낮다(약하다)
		this.arm = new Arm();
	}
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Arm getArm() {
		return arm;
	}
	public void setArm(Arm arm) {
		this.arm = arm;
	}
	
	
}

