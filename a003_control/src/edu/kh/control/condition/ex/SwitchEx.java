package edu.kh.control.condition.ex;

import java.util.Random;
import java.util.Scanner;

public class SwitchEx {
	Scanner sc = new Scanner(System.in);
	/* switch문(switch - case문)
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 *  -> 식의 결과에 맞는 case문이 수행 됨.
	 *  
	 *  [작성법]
	 *  switch(식){ // 식 수행 결과는 true/false가 아닌 값(정수, 문자열제일 많이 씀)
	 *  
	 *  case 결과값1 : 수행코드 1; break;
	 *  case 결과값2 : 수행코드 2; break;
	 *  case 결과값3 : 수행코드 3; break;
	 *  default : 모든 case가 만족하지 않을 경우 수행하는 코드;
	 *  }
	 * */
	
	// switch 예시 1
	public void ex1() {
		// 키보드로 정수를 입력 받아
		// 1이면 "RED"
		// 2이면 "ORANGE"
		// 3이면 "YELLOW"
		// 4이면 "GREEN"
		// 1~4 아니면 "BLUE" 를 출력.
		
		// sc -> ctrl + spacebar -> Scanner 선택
		// => 자동완성(문구 완성, import 추가)

		
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		String res="";
		// 1) if - else if - else 버전
//		if(input == 1) {
//			res = "RED";
//		} else if (input == 2) {
//			res = "ORANGE";
//		} else if (input == 3) {
//			res = "YELLOW";
//		} else if (input == 4) {
//			res = "GREEN";
//		} else {
//			res = "BLUE";
//		}
		// 2) switch 버전
		switch(input) {
		case 1:res = "RED"; break;
		case 2:res = "ORANGE"; break;
		case 3:res = "YELLOW"; break;
		case 4:res = "GREEN"; break;
		default:res = "BLUE"; break;
		}
		
		System.out.println(res);
	}
	
	// switch 예시 2
	public void ex2() {
		// 랜덤 팀 배정 프로그램
		// (백팀0, 청팀1, 홍팀2)
		
		// * Java에서 랜덤한 수(난수) 발생시키는 방법 *
		// Math.random() : 난수 발생
		// 1) 난수 발생 범위 : 0.0 <= random < 1.0
		// 2) 발생한 난수의 자료형 : double
		// + 실수 -> 정수 강제 형변환 : 소수점 버림
		// Math.random();		// 0.0 <= random < 1.0
		// Math.random() * 3	// 0.0 <= random * 3 < 3.0
		// (int)(Math.random() * 3) // 0 <= random * 3 < 3
		
		

		int random = (int)(Math.random()*3);
		String result;
		switch(random) {
		case 0 : result = "백팀"; break;
		case 1 : result = "청팀"; break;
		default : result = "홍팀";
		}
		
		System.out.println(result);
	}
	
	// switch 예시 3 : 식의 결과가 "문자열" (String)
	public void ex3() {
		// scan -> ctrl + spacebar -> enter
		Scanner sc = new Scanner(System.in);
		
		// 메뉴를 입력 받아서 가격이 얼마인지 출력하기
		
		System.out.print("메뉴를 입력하세요(김밥/라면/샌드위치/떡볶이) : ");
		
		String input = sc.next();
		
		int price; // 가격을 저장할 변수 선언
		switch(input) {
		case "김밥": price = 4500;break;
		case "라면": price = 3500;break;
		case "샌드위치": price = 5800;break;
		case "떡볶이": price = 4000;break;
		default:price = -1;
		//잘못 입력한 경우에 사용하지 않는 숫자(-1)를 이용해서 표현
		}
		if ( price != -1)
			System.out.printf("%s은/는 %d원 입니다.",input,price);
		else // price가 -1인 경우
			System.out.println("존재하지 않는 메뉴 입니다.");
	}
	
	//switch 예시 4
	public void ex4() {
		Scanner sc = new Scanner(System.in);
	      // 산술 연산 계산기 만들기
	      // 두 정수(int)와 1개의 연산자( + - * / % (String) )를 입력 받아서 
	      // 연산 결과를 출력
	      // 단, 나누기(/) 연산 시 0으로는 나눌 수 없도록 한다.
		
	      // [실행 화면]
	      // 정수1 입력 : 5
	      // 연산자 입력 : +
	      // 정수2 입력 : 4
	      // 5 + 4 = 9
	      
	      // [실행 화면]
	      // 정수1 입력 : 5
	      // 연산자 입력 : /
	      // 정수2 입력 : 0
	      // 0으로는 나눌 수 없습니다.
	      
	      // [실행 화면]
	      // 정수1 입력 : 5
	      // 연산자 입력 : @
	      // 정수2 입력 : 3
	      // 존재하지 않는 연산자 입니다.
		System.out.print("정수1 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("연산자 입력 : ");
		String op = sc.next();
		System.out.print("정수2 입력 : ");
		int input2 = sc.nextInt();
		double res = 0;
		boolean err=false,err2=false;
		switch(op) {
		case "+":res=input1+input2;break;
		case "-":res=input1-input2;break;
		case "*":res=input1*input2;break;
		case "/":if(input2==0) err=true; else res=input1/(double)input2;break;
		case "%":if(input2==0) err=true; else res=input1%input2;break;
		default:err2=true;
		}
		if(err)
			System.out.println("0으로는 나눌 수 없습니다.");
		else if(err2)
			System.out.println("존재하지 않는 연산자 입니다.");
		else if(!op.equals("/"))
			System.out.printf("%d %s %d = %d",input1,op,input2,(int)res);
		else
			System.out.printf("%d %s %d = %.3f",input1,op,input2,res);
	}
	
	// switch 예시 5 : break의 역할
	// 계절 판별(switch version)
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		
		// break : 멈추다
		// -> 해당 case를 수행한 후 멈춰라
		// -> break 미작성 시 다음 case가 연달아 수행된다!
		// * case 마다 꼭 코드가 작성될 필요는 없다@!
		switch(month) {
		case 12:case 1:	case 2:result = "겨울";break;
		case 3:	case 4:	case 5:result = "봄";break;
		case 6:	case 7:	case 8:result = "여름";break;
		case 9:	case 10:case 11:result = "가을";break;
		default:result = "잘못 입력 하셨습니다.";
		}
		System.out.println(result);
	}
}