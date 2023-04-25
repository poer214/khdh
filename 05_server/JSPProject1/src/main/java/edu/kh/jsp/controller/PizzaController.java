package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Pizza;

@WebServlet("/pizzaOrder")
public class PizzaController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza("치즈 피자",8000));
		pizzaList.add(new Pizza("콤비네이션 피자",9000));
		pizzaList.add(new Pizza("핫치킨 피자",10000));
		
		req.setCharacterEncoding("UTF-8");
		String pizza = req.getParameter("pizza"); // 1, 2, 3
		String size = req.getParameter("size"); // R, L
		String amount = req.getParameter("amount"); // 수량(0 이상)
		
		// L 사이즈는 2천원 추가
		
		
		
		
		// 피자 종류 : 핫치킨 피자(L)
		// 수량 : 2
		// 총 가격 : 24,000 원; 
		
		// 피자 종류 파악
		Pizza p = pizzaList.get(Integer.parseInt(pizza) - 1);
		int price = (p.getPrice()+(size.equals("L")?2000:0))*Integer.parseInt(amount);
		req.setAttribute("pizzaName", p.getName());
		req.setAttribute("price", price);
		
		req.getRequestDispatcher("/WEB-INF/views/pizzaResult.jsp").forward(req, resp);
	}
}