package edu.kh.oop.basic;

public class BasicRun {
	

	public static void main(String[] args) {
		
		// 국민 객체 생성
		Nation n1 = new Nation();
		Nation n2 = new Nation();
		Nation n3 = new Nation();
		
		n1.setpNo("990123-1234567(간접 접근 이용)");
		n1.name = "홍길동";
		n1.gender = '남';
		n1.address = "서울시 중구 남대문로 120";
		n1.phone = "010-1234-1234";
		n1.age = 25;
		
		System.out.println(n1.getpNo());
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		
		n1.medicalBenefits();
		n1.speakKorean();
	}

}
