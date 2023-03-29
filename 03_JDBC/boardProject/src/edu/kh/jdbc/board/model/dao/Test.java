package edu.kh.jdbc.board.model.dao;

import edu.kh.jdbc.board.model.service.CommentService;

public class Test {
	CommentService service = new CommentService();
	public Test() {
		try {
			System.out.println(service.confirmCommentNo(1, 1, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Test();
	}
}
