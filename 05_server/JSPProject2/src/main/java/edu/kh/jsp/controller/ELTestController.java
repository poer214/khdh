package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Book;

@WebServlet("/elTest")
public class ELTestController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("address", "서울시 중구 남대문로 120");
		req.setAttribute("score", 100);
		List<String> strList = new ArrayList<>();
		strList.add("가가가");
		strList.add("나나나");
		strList.add("다다다");
		req.setAttribute("strList", strList);
		Book book = new Book("어린왕자", "생텍쥐베리", 4000);
		req.setAttribute("book", book);
		
		List<String> list1 = null;
		List<String> list2 = new ArrayList<>();
		String strArr[] = {"a","b","c"};
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("strArr", strArr);
		
		
		req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp").forward(req, resp);
	}
}