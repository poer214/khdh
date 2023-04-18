package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식의 문제점 : 한글이 깨진다(인코딩 불일치 문제)
		req.setCharacterEncoding("UTF-8"); // 요청 데이터 인코딩 변경
		
		// 전달 받은 값(파라미터) 다 얻어와 변수에 저장
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println(id+"\n"+pw);
		
		// id/pw가 user01/pass01 과 일치하면 "로그인 성공"
		// 일치하지 않음 "아이디 또는 비밀번호가 일치하지 않습니다"
		String message = null;
		if( id.equals("user01") && pw.equals("pass01") ) {
			message = "로그인 성공";
		} else {
			message = "아이디 또는 비밀번호가 일치하지 않습니다";
		}
		
		// Servlet으로 클라이언트에게 응답할 화면 만들기.
		// -> 작성하기 힘드니까 JSP로 위임
		// Request : 요청
		// Dispatcher : 발송자, 필요한 정보를 제공하는 자, 역할을 넘긴다.
		
		
		// 기존에 req에 없던 값(message)을 속성(Attribute)으로 추가
		req.setAttribute("message", message);
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		// ** forward **
		
		// forward를 하면
		// 주소창이 요청 주소로 바뀌고
		// 그 요청에 맞는 화면으로 변함
		// (요청에 맞는 응답을 했기 때문에)
		// -> Servelet이 가지고 있던 req, resp 객체를
		//	  JSP에게 전달하여 요청을 실제로 위임
		requestDispatcher.forward(req, resp);
		
		
		
		// ** redirect **
		
		// 다시 다른 요청을 함(재요청)
		// -> 현재 요청("login")에 대한 응답 화면이 따로 존재하지 않아서 응답화면이 있는 다른 요청 주소로 다시 요청
		// resp.sendRedirect("/"); // 메인 페이지를 다시 요청
		// "/" 요청에 대한 처리 = http://localhost/ (index.html)
	}
}