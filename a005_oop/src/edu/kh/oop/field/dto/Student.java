package edu.kh.oop.field.dto;

import java.util.Scanner;

// DTO (Data Tranfer Object) : 데이터를 옮기는 객체
public class Student {
	// 필드 : 객체의 속성
	
	// 필드 종류 1 : 인스턴스 변수
	public String name;
	public int grade;
	
	// 필드 종류 2 : 클래스 변수
	public static String schoolName = "KH초등학교";
	
	public void study() {
		System.out.println("매우 매우 열심히 공부합니다.");
	}	
}