package edu.kh.oop.constructor.run;

import edu.kh.oop.constructor.dto.Member;

public class ConstructorRun {
	public static void main(String[] args) {
		Member mem1 = new Member(); // 기본 생성자를 이용해서 Member 객체 생성
		
		Member mem2 = new Member("user02", "pass02","김삼순",19); // 매개변수 생성자를 이용해서 Member 객체 생성
		
		System.out.println("-------------");
	}
}
