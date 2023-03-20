package edu.kh.oop.method.dto;

// DTO (Data Transfer Object) : 값 전달용 개체
public class User {
	
	// 아이디, 비밀번호, 이름, 성별(M/F)
	private String userId;
	private String userPw;
	private String userName;
	private char userGender;

	// 생성자
	public User() {}; // 기본 생성자
	
	// 매개변수 생성자 (오버로딩 적용)
	public User(String userId, String userPw, String userName, char userGender) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userGender = userGender;
	}
	
	// 메서드
	// toString() : 객체가 가지고 있는 모든 필드 값을 하나의 문자열로 표기하여 반환
	public String toString() {
		return String.format("%s / %s / %s / %c", userId, userPw, userName, userGender);
	}
	
	
	// getter / setter 작성
	// -> 캡슐화 원칙에 의해
	//    직접 접근이 차단된 필드와 데이터 교환을 할 수 있는 기능(간접 접근방법)
	
	// getter 작성법 (외부에서 필드값을 얻어갈 수 있게 하는 방법)
	// public 반환형 get필드명() {
	//    return 필드명;
	// }
	
	public String getUserId() {
		return userId;
	}
	
	// setter 작성법 (외부에서 값을 받아와 필드값을 설정)
	// public void set필드명(자료형 필드명) {
	//     this.필드명 = 필드명;
	// }
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
}