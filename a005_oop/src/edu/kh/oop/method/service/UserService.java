package edu.kh.oop.method.service;

import edu.kh.oop.method.dto.User;
import edu.kh.oop.method.view.UserView;

public class UserService {
	
	public UserService() {
		//기본 생성자로 객체 생성 시
		// UserView.loginUser에 객체 주소 대입하기
		UserView.loginUser = new User("user01", "pass01", "테스트", 'F');
	}
	
	public User signUp(String userId, String userPw, String userPwConfirm,
					   String userName, char userGender) {
		
		// 전달 받은 값 중 비밀번호, 비밀번호 확인이 일치할 경우
		// User 객체를 생성해서 주소를 반환
		// 만약 일치하지 않은 경우 null 반환
		
		User user = null; // 아무것도 참조하지 않음
		
		if (userPw.equals(userPwConfirm)) {
			user = new User(userId, userPw, userName, userGender);
		}

		return user; // 주소 또는 null 반환
	}
	
	public void login(String userId, String userPw, User signUpUser) {
					// 입력 받은 값
		
		// 아이디 일치 여부 검사
		boolean idCheck = userId.equals(signUpUser.getUserId());
		// 비밀번호 일치 여부 검사
		boolean pwCheck = userPw.equals(signUpUser.getUserPw());
		
		// 아이디, 비밀번호가 모두 일치하는 경우
		if(idCheck && pwCheck) {
			// 로그인 처리
			
			// UserView에 있는 클래스 변수 (static) login(User())
			// 가입한 회원의 정보를 가지고 있는 객체의 주소를 대입.
		}
		
		
	}
	
	public boolean userUpdate(String userName, char userGender, String userPw) {
		if(!UserView.loginUser.getUserPw().equals(userPw))
			return false;
		UserView.loginUser.setUserName(userName);
		UserView.loginUser.setUserGender(userGender);
		
		return true;
	}
}