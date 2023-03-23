package edu.kh.jdbc.model.dto;

public class Department {
	private String departmentTitle;
	private int person;
	private double avgSalary;
	public Department() {}
	public String getDepartmentTitle() {
		return departmentTitle;
	}
	public void setDepartmentTitle(String departmentTitle) {
		this.departmentTitle = departmentTitle;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public double getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}
}
