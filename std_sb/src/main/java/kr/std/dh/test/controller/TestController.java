package kr.std.dh.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.std.dh.test.dto.TestDto;


@RestController
public class TestController {
	
	@GetMapping(value = "/")
	public String hello(){
		return "Hello World 123";
	}
	
	@GetMapping("/test")
	public TestDto test() {
		TestDto dto = new TestDto();
		dto.setName("홍길동");
		dto.setAge(10);
		return dto;
	}
}