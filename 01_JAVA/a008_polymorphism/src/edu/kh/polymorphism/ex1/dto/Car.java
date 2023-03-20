package edu.kh.polymorphism.ex1.dto;

public class Car extends Object{
	// 필드
	private int wheel;		// 바퀴 개수
	private int seat;		// 좌석 수
	private String fuel;	// 연료
	
	// 생성자
	public Car() {}
	
	public Car(int wheel, int seet, String fuel) {
		super();
		this.wheel = wheel;
		this.seat = seet;
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seet) {
		this.seat = seet;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	// Object.toString() 오버라이딩
	@Override
	public String toString() {
		return String.format("%d / %d / %s",wheel,seat,fuel);
	}
	
}