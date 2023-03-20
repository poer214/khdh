package edu.kh.oop.constructor.dto;

public class Member {
	
	// 추상화 : 아이디, 비밀번호, 이름, 나이
	// 필드(== 멤버변수)
	
	// 인스턴스 변수
	private String memberId = "명시적 초기화";
	private String memberPw;
	private String memberName;
	private int memberAge;
	
	public static String programName;
	
	// 초기화 블럭 : 필드를 초기화(값 대입)
	{
		memberId = "mem1";
		memberPw = "1234";
		memberName = "고길동";
		memberAge = 40;
	}
	
	// 클래스 초기화 블럭
	// - 프로그램 실행 시 static 변수를 초기화 하는 용도의 블럭
	//   (프로그램 실행 시 1회만 수행됨)
	static {
		programName = "회원관리 프로그램";
	}
	
	// 기능
	// 생성자 : 객체를 생성하는 기능
	
	// 생성자 작성 규칙
	// 1. 반환형 (void, int, String...)이 없다.
	// 2. 생성자명은 클래스와 동일!
	
	public Member(){// 기본 생성자 ()안에 아무것도 없음
		
		/************************************************
		 * 클래스 내에 아무런 생성자도 작성되지 않은 경우				*
		 * 컴파일러가 자동으로 기본 생성자를 추가해준다!				*
		 * 												*
		 * public Member(){}							*
		 * 단, 기본 생성자만 없고								*
		 * 다른 매개변수 생성자가 존재하면 						*
		 * 컴파일러는 자동으로 기본 생성자를 추가하지 않는다!			*
		 * **********************************************/
		
		//객체 생성시 특정 기능 수행
		System.out.println("기본 생성자로 생성됨.");
		
		
		// 객체 생성시 필드 초기화
		memberId = "user1";
		memberPw = "1q2w3e4r";
		memberName = "홍길동";
		memberAge = 25;
	}
	
	
	// 매개변수 생성자
	// - 객체 생성 시(생성자 호출 시)
	//   () 안에 객체의 필드를 초기화할 값을 전달 받는 생성자
	
	public Member(String memberId, String memberPw, String memberName, int memberAge){
		
		// Member() 생성자 호출 시
		// () 안에 String, String, String, int 을 작성해라
		
		System.out.println("매개변수 생성자(String,String,String,int)로 생성");
		
		// 전달 받은 값을 필드에 대입
		// this. (this 참조 변수)
		// - 모든 인스턴스에 숨겨져있는 필드로
		// 현재 인스턴스(객체)의 시작주소가 저장되어 있어
		// 현재 인스턴스 참조함. (가리킴)
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		System.out.println(memberId+" 마지막");
	}
	
	public Member(String memberId) {
		this(); // 현재 클래스의 기본 생성자 호출
		// --> this() 생성자
		// --> 중복 제거, 코드 길이 감소를 위해서 사용
		
		this.memberId = memberId;
	} //오버로딩 성립
	public Member(String memberId, String memberPw) {} // 성립(개수)
	
	// 일반 기능(메서드)
	
}