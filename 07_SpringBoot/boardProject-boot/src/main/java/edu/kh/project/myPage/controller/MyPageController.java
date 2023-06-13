package edu.kh.project.myPage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SessionAttributes({"loginMember"})
// 1) Model에 세팅된 값의 key와 {}작성된 값이 일치하면 session scope로 이동
// 2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게 함.
//		-> @SessionAttribute(key)로 사용

@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받음
@Controller // 요청/응답 제어
public class MyPageController {
	
	@Autowired // MyPageService의 자식 MyPageServiceImpl 의존성 주입(DI)
	private MyPageService service;
	
	@GetMapping("/info")
	public String info() {
		return "myPage/myPage-info";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "myPage/myPage-profile";
	}
	
	@GetMapping("/changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	@GetMapping("/secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	@PostMapping("/info")
	public String updateInfo(Member updateMember
			, String[] memberAddress
			, @SessionAttribute("loginMember") Member loginMember
			, RedirectAttributes ra) {
		
		// ----------------------- 매개 변수 설명 ------------------------
		// Member updateMember : 커맨드 객체(제출된 파라미터가 저장된 객체)
		
		// String[] memberAddress : name="memberAddress"인 input 3개의 값이 담긴 배열(주소)
		
		// @SessionAttribute("loginMember") Member loginMember
		// 	-> Session에서 얻어온 "loginMember"에 해당하는 객체를
		//     매개 변수 Member loginMember에 저장
		// ---------------------------------------------------------------
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		int result = service.updateInfo(updateMember);
		
		String message = null;
		
		if(result > 0) {
			
			message = "회원 정보가 수정되었습니다.";
			
			// Session에 로그인된 회원 정보도 수정(동기화)
			
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
			
		} else {
			message = "회원 정보 수정 실패";
		}
		
		ra.addFlashAttribute("message",message);
		
		return "redirect:info"; // 상대 경로(/myPage/info GET 방식)
	}
	
	@PostMapping("/changePw")
	public String changePw(String currentPw, String newPw,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		// 로그인한 회원 번호(DB에서 어떤 회원을 조회, 수정 알아야 되니까)
		int memberNo = loginMember.getMemberNo();
		
		// 비밀번호 변경 서비스 호출
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String path = "redirect:";
		String message = null;
		
		if(result > 0) { // 변경 성공
			message = "비밀번호가 변경 되었습니다.";
			path += "info";
		} else { // 변경 실패
			message = "현재 비밀번호가 일치하지 않습니다.";
			path += "changePw";
		}
		ra.addFlashAttribute("message",message);
		return path;
	}
	
	@PostMapping("/secession")
	public String secession(String memberPw, @SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra,
			SessionStatus status,
			HttpServletResponse resp) {
		// String memberPw : 입력한 비밀번호
		// 1. 로그인한 회원의 회원 번호 얻어오기
		int memberNo = loginMember.getMemberNo();
		
		// 2. 회원 탈퇴 서비스 호출
		//  - 비밀번호가 일치하면 -> MEMBER_DEL_FL -> 'Y'로 바꾸고 1 반환
		//  - 비밀번호가 일치하지 않으면 -> 0 반환
		int result = service.secession(memberPw,memberNo);
		
		String path = "redirect:";
		String message = null;
		
		if(result > 0) {
			// 3. 탈퇴 성공 시
			//  - 로그아웃
			status.setComplete();
			//  - message : 탈퇴 되었습니다.
			message = "탈퇴 되었습니다.";
			//  - 메인 페이지로 리다이렉트
			path += "/";
			//  + 쿠키 삭제
			Cookie cookie = new Cookie("saveId","");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			resp.addCookie(cookie);
		} else {
			// 4. 탈퇴 실패 시
			//  - message : 현재 비밀번호가 일치하지 않습니다.
			message = "현재 비밀번호가 일치하지 않습니다.";
			//  - 회원 탈퇴 페이지로 리다이렉트
			path += "secession";
		}
		ra.addFlashAttribute("message",message);
		return path;
	}
	
	/* MultipartFile : input type="file"로 제출된 파일을 저장한 객체
	 * 
	 * [제공하는 메서드]
	 * - transferTo() : 파일을 지정된 경로에 저장(메모리 -> HDD/SSD)
	 * - getOriginalFileName() : 파일 원본명 
	 * - getSize() : 파일 크기
	 * */
	
	// 프로필 이미지 수정
	@PostMapping("/profile")
	public String updateProfile(
			/* @RequestParam("profileImage") */ MultipartFile profileImage
			, @SessionAttribute("loginMember") Member loginMember
			, RedirectAttributes ra // 리다이렉트시 메시지 전달
			)  throws IllegalStateException, IOException {
		
		// 프로필 이미지 수정 서비스 호출
		int result = service.updateProfile(profileImage, loginMember);
		
		String message = null;
		if(result > 0) message = "프로필 이미지가 변경되었습니다";
		else message = "프로필 변경 실패";
		
		ra.addFlashAttribute("message",message);
		System.out.println(message);
		
		return "redirect:profile";
	}
}