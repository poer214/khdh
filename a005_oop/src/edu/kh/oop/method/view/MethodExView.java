package edu.kh.oop.method.view;

import java.util.Scanner;

// View : 프로그램 실행 시 보여지는 부분
// -> 콘솔에 내용을 출력, 입력 받는 용도의 객체를 만들기 위한 클래스

public class MethodExView {

	// 필드 (==멤버변수)
	private Scanner sc = new Scanner(System.in);
	// 클래스 내 어디서든 사용 가능한 Scanner 객체 생성
	
	// void : 반환 값이 없다.
	public void displayMenu() { // 메뉴 표시(출력) 기능
		
		int input = 0; // 입력 받은 정수를 저장할 변수
		
		do {
			System.out.println("---------------------------");
			System.out.println("1. 매개 변수 X, 반환 값 X");
			System.out.println("2. 매개 변수 O, 반환 값 X");
			System.out.println("3. 매개 변수 X, 반환 값 O");
			System.out.println("4. 매개 변수 O, 반환 값 O");
			System.out.println("0. 프로그램 종료");
			System.out.println("---------------------------");
			System.out.print("메뉴 번호 입력 >> ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1:menu1();break; // 1
			case 2:break;
			case 3:break;
			case 4:break;
			case 0: System.out.println("<프로그램 종료>"); break;
			default:System.out.println("잘못 입력 하셨습니다.");
			}
		} while(input != 0);
	}
	    
	// 1. 매개 변수 X, 반환 값 X
	// [접근 제한자] [예약어] 반환형 메서드명([매개변수]) {}
	private void menu1() {
		System.out.println("*** menu1() 실행 *** ");
		int a = 10;
		int b = 20;
		
		System.out.println("a + b = " + (a+b));
	}
}