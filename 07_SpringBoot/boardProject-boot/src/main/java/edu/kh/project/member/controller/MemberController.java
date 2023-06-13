package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@SessionAttributes({ "loginMember" })
public class MemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("/login")
	public String login(HttpSession session, @SessionAttribute(value="loginMember", required=false) Member loginMember
			,Model model, @RequestHeader(value="referer", required=false) String referer) {
		session.setAttribute("prevPage",referer);
		String path = null;
		if(loginMember == null) {
			path = "member/login";
		} else {
			path = "redirect:/";
		}
		return path;
	}

	@PostMapping("/login")
	public String login(Member inputMember, Model model, @RequestHeader(value = "referer") String referer,
			@RequestParam(value = "saveId", required = false) String saveId, HttpServletResponse resp,
			RedirectAttributes ra, @SessionAttribute(value = "prevPage", required = false) String prevPage,
			HttpServletRequest req, SessionStatus session) {
		Member loginMember = service.login(inputMember);
		String path = "redirect:";
		if (loginMember != null) {
			if (prevPage == null)
				path += "/";
			else {
				path += prevPage;
				req.getSession().removeAttribute("prevPage");
			}
			model.addAttribute("loginMember", loginMember);
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());

			if (saveId != null)
				cookie.setMaxAge(60 * 60 * 24 * 30);
			else
				cookie.setMaxAge(0);

			cookie.setPath("/");
			resp.addCookie(cookie);

		} else {
			path += referer;
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return path;
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status, @RequestHeader(value = "referer") String referer) {
		status.setComplete();
		return "redirect:" + referer;
	}

	@GetMapping("/signUp")
	public String signUp() {
		return "member/signUp";
	}

	@PostMapping("/signUp")
	public String signUp(Member inputMember, String[] memberAddress, RedirectAttributes ra) {
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
		} else {
			inputMember.setMemberAddress(String.join("^^^",memberAddress)) ;
		}
		
		String path = "redirect:";
		String message = null;
		
		int result = service.signUp(inputMember);
		
		if(result > 0) {
			path += "/";
			message = inputMember.getMemberNickname() + " 님의 가입을 환영합니다.";
		} else {
			path += "member/signUp";
			path += "signUp";
			message = "회원 가입 실패!";
		}
		ra.addFlashAttribute("message",message);
		return path;
	}
}