package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@Controller	// 요청/응답 클래스 + bean 등록(Spring이 관리하는 클래스)

// @RequestMapping: 요청 주소에 맞는 클래스/메서드 연결
// @RequestMapping("요청 주소")
// -> GET / POST 구분 X (모두 받음, 주소만 맞으면 연결)

// @RequesteMapping(value="요청 주소", method="RequestMethod.GET/POST)
// -> GET / POST 구분 ()



@RequestMapping("/member") // 공통된 주소 앞부분 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리
public class MemberController {
	
	@Autowired
	MemberService service;
	
	// 로그인	: /member/login
	// 로그아웃	: /member/logout
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(HttpServletRequest req) {
//	public String login(@RequestParam String inputEmail) {
//	public String login(String inputEmail, String inputPw) {
	public String login(HttpServletRequest req) {
		// 파라미터 전달 방법 1 : HttpServletRequest를 이용하는 방법
		// -> Controller 메서드에 매개변수로 HttpServletRequest 작성
		// 매개변수에 적으면 왜 사용 가능할까??
		// Spring Framework가 제공하는 Argument Resolver(매개변수 해결사)
		
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		
		
		// 파라미터 전달 방법 2 : 
		
		
		
		// ** redirect 방법 ! **
		// "redirect:요청주소"
		System.out.println(inputEmail + " / " + inputPw);
		return "redirect:/";
	}
	
//	@PostMapping("/login")
	public String login(/* @RequestParam("inputEmail") */String inputEmail) {
		
		// 파라미터 전달 방법 2 : @RequestParam 어노테이션 이용(+생략 방법)
		
		// @RequestParam 어노테이션
		
		   // - request객체를 이용한 파라미터 전달 어노테이션
		   // - 매개변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 주입됨.
		
		   // ** 파라미터의 name 속성 값과
		   //	매개변수 명이 같으면 어노테이션 생략 가능 

		   // @RequestParam(vlaue="name", required="false", defaultValue="1")
		   // [속성]
		   // value : 전달 받은 input 태그의 name 속성값
		   
		   // required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		   // -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		   // -> required = true인 파라미터가 null인 경우에도 400 Bad Request

		   // defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		   // -> required = false인 경우 사용
		System.out.println(inputEmail);
		
		return "redirect:/";
	}
	
//	@PostMapping("/login")
	public String login(/* @ModelAttribute */Member inputMember) {
		
		// 파라미터 전달 방법 3 : @ModelAttriubute를 이용한 방법
		
		// - DTO(또는 VO)와 같이 사용하는 어노테이션
		// - 전달 받은 파라미터의 name 속성 값이
		//   같이 사용되는 DTO의 필드명과 같다면
		//   자동으로 setter를 호출해서 필드에 값을 세팅
		
		// *** @ModelAttribute 사용 시 주의사항 ***
		// - DTO에 기본 생성자가 필수로 존재해야 한다.
		// - DTO에 setter가 필수로 존재해야 한다.
		
		// *** @ModelAttribute 어노테이션은 생략이 가능하다! ***
		// *** @ModelAttribute 를 이용해 값이 필드에 세팅된 객체를
		//		"커맨드객체 : Command Object" 라고 한다.
		// HttpServletRequest 를 통해 들어온 요청 파라미터들을 setter 메서드를 이용하여 객체에 정의되어있는 속성에 바인딩이 되는 객체
		
		System.out.println(inputMember);
		
		return "redirect:/";
	}
	
	
	/** 로그인 요청 처리(찐)
	 * @return 메인페이지 redirect 주소
	 */
	@PostMapping("/login")
	public String login(Member inputMember, Model model) {
		
		// Member inputMember : 커맨드 객체(필드에 파라미터 담겨있음)
		Member loginMember = service.login(inputMember);
		
		System.out.println(loginMember);
		
		return "redirect:/";
	}
}