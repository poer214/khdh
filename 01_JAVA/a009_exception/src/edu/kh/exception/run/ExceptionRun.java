package edu.kh.exception.run;

import java.io.IOException;

import edu.kh.exception.service.ExceptionService;

public class ExceptionRun {
	
	public static void main(String[] args) throws IOException {

		ExceptionService service = new ExceptionService();
		
//		service.ex1();
//		service.ex2();
//		service.ex3();
//		service.ex4();
//		service.ex5();
		service.startEx5();
		
	}
}