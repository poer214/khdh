package edu.kh.oop.method.view;

import java.util.Scanner;

import edu.kh.oop.method.dto.User;
import edu.kh.oop.method.service.UserService;

// 입/출력용 객체를 만들기 위한 클래스
public class UserView {
	
	private Scanner sc =  new Scanner(System.in);
	private UserService service = new UserService();
	
	// 가입한 사용자 정보를 가지고 있는 객체를 참조할 변수 선언
	private User signUpUser = null;
	
	// 로그인한 사용자 정보를 가지고 있는 객체를 참조할 변수 선언
	
	// 프로그램 시작 시 static 영역에 생성
	// -> 어디서든지 클래스명.필드명으로 접근 가능
	public static User loginUser = null;
	
	
	// 메뉴를 출력하는 메서드
	public void displayMenu(){
		int input = 0; // 입력한 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("----- 사용자 기능 메뉴 -----");
			
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 로그아웃");
			System.out.println("4. 회원 정보 출력");
			System.out.println("5. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			System.out.println("------------------------");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			
			System.out.println(); // 개행
			
			switch(input) {
			case 1 : this.signUp(); break;
			case 2 : this.login();break;
			case 3 : this.logout();break;
			case 4 : this.userPrint();break;
			case 5 : this.userUpdate();break;
			case 0 : System.out.println("<프로그램 종료>");break;
			default: System.out.println("잘못 입력 하셨습니다.");
			}
			
			System.out.println(); // 개행
			
		}while(input != 0);
	}
	
	private void signUp() {
		System.out.println("*** 회원 가입 ***");
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("PW : ");
		String userPw = sc.next();
		System.out.print("PW 확인 : ");
		String userPwConfirm = sc.next();
		
		
		System.out.print("이름 : ");
		String userName = sc.next();
		System.out.print("성별(M/F) : ");
		char userGender = sc.next().charAt(0);
		
		signUpUser = service.signUp(userId, userPw, userPwConfirm, userName, userGender);
		
		if(signUpUser != null) {
			System.out.println("[[[[회원 가입 성공]]]]");
		} else {
			System.out.println("[비밀번호가 일치하지 않습니다.]");
		}
	}
	
	private void login() {
		// void : 반환 값이 없다 (return은 존재)
		System.out.println("*** 로그인 ***");
		
		// 회원가입된 User가 없을 경우
		if(signUpUser == null) {
			System.out.println("[먼저 회원 가입 후 진행해주세요.]");
			return; // 현재 메서드를 종료하고 호출한 곳으로 돌아감
		}
		
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("PW : ");
		String userPw = sc.next();
		
		// 입력 받은 값 + signUpUser를 Service의 login 메서드로 전달하여
		// 아이디 비밀번호 일치 시 로그인
		service.login(userId,userPw,signUpUser);
	}
	
	private void logout() {
		
		//로그인 상태인 경우 로그아웃을 수행
		if(UserView.loginUser != null) {
			UserView.loginUser = null;
			System.out.println("[로그아웃 되었습니다.]");
		}
		else {
			System.out.println("[로그인 후 이용해주세요.]");
		}
	}
	
	// 4. 회원 정보 출력
	public void  userPrint() {
		if(UserView.loginUser != null)
			System.out.println(UserView.loginUser.toString());
		else System.out.println("[로그인 후 이용해주세요]");
	}
	
	// 5. 회원 정보 수정
	public void userUpdate() {
		System.out.println("*** 5. 회원 정보 수정 ***");
		if(UserView.loginUser != null) { // 로그인이 되어있는 경우
			// 이름, 성별만 변경 가능
			// 단, 비밀번호 일치해야만 수정 가능
			System.out.print("이름 : ");
			String userName = sc.next();
			
			System.out.print("성별 : ");
			char userGender = sc.next().charAt(0);
			
			System.out.print("PW : ");
			String userPw = sc.next();
			
			if(service.userUpdate(userName,userGender,userPw)) {
				System.out.println("정보 변경 성공");
			} else {
				System.out.println("정보 변경 실패");
			}
			
		} else { // 로그인이 되어있지 않은 경우
			System.out.println("[로그인 후 이용해주세요.]");
		}
	}
}