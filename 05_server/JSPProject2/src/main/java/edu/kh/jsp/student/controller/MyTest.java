package edu.kh.jsp.student.controller;

import java.util.List;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;

public class MyTest {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		String path = null;
		try {
			List<Student> list = service.selectAll();
			System.out.println(list);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
