package edu.kh.inheritance.dto;

					// 확장하다 (Parent의 코드를 상속 받아 Child1 확장)
public class Child1 extends Parent{
	private String car;
	
	// 생성자
	public Child1() {
		super();
		System.out.println("기본 생성자");
	}
	
	public Child1(String car) {
		super();
		
		
		setMoney(100_000_000);
		setLastName("김");
		
		this.car = car;
		System.out.println("Child1(String) 매개변수 생성자");
	}
	
	public String getCar() {
		return car;
	}
	
	public void setCar(String car) {
		this.car = car;
	}
	public String toString() {
		System.out.println(getCar());
//		System.out.println(getMoney());
		System.out.println(getLastName());
		return car;
	}
	
//	@Override
//	public int getMoney() {
//		System.out.println(super.getMoney()+500);
//	}
}
