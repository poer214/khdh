package edu.kh.collection.list.dto;

import java.util.Objects;

public class Student implements Comparable<Student>{
	private String name;
	private int grade;
	private int classRoom;
	private int number;
	private String address;
	private char gender;
	private int score;
	public Student() {}
	public Student(String name, int grade, int classRoom, int number, String address, char gender, int score) {
		super();
		this.name = name;
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.address = address;
		this.gender = gender;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", classRoom=" + classRoom + ", number=" + number
				+ ", address=" + address + ", gender=" + gender + ", score=" + score + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, classRoom, gender, grade, name, number, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && classRoom == other.classRoom && gender == other.gender
				&& grade == other.grade && Objects.equals(name, other.name) && number == other.number
				&& score == other.score;
	}
	@Override
	public int compareTo(Student other) {

		// Student 객체로 이루어진 컬렉션을 정렬하라고 할때
		// 별도의 다른 기준이 없다면 score 순서로 정렬
		
		// compareTo() 메서드에서
		// 반환되는 값이 
		// 0 이하 라면 : 순서를 그대로 유지
		// 0 초과(양수) : 큰 값이 오른쪽으로 이동0)
		//			-> 정확히는 리턴값이 양수이면 현재 객체를 오른쪽으로 이동
		return this.score - other.score;
		
//		return other.score - this.score;		
	}
}