package edu.kh.project.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	// 요청/응답 클래스 + bean 등록(Spring이 관리하는 클래스)
@RequestMapping("/member") // 공통된 주소 앞부분 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리
public class MemberController {
	
	// 로그인	: /member/login
	// 로그아웃	: /member/logout
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	
//	public String login(HttpServletRequest req) {
//	public String login(@RequestParam String inputEmail) {
	public String login(String inputEmail, String inputPw) {
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// ** redirect 방법 ! **
		// "redirect:요청주소"
		return "redirect:/";
	}
	public String logout() {
		
		
		return "logout";
	}
	
	
	
	
}