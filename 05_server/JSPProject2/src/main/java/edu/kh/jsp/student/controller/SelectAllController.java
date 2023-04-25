package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;

@WebServlet("/jstl/student/selectAll")
public class SelectAllController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서비스 객체 생성
		StudentService service = new StudentService();
		String path = null;
		try {
			List<Student> list = service.selectAll();
			req.setAttribute("stdList", list);
			path = "/WEB-INF/views/student/select.jsp";
		} catch(Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
}