package edu.kh.jdbc.dto;

public class Employee2 {
	String departmentTitle;
	String jobName;
	String employeeName;
	String email;
	
	
	public Employee2() {}
	public Employee2(String departmentTitle, String jobName, String employeeName, String email) {
		if(departmentTitle == null)
			departmentTitle = "부서없음";
		this.departmentTitle = departmentTitle;
		
		this.jobName = jobName;
		this.employeeName = employeeName;
		this.email = email;
	}
	public String getDepartmentTitle() {
		return departmentTitle;
	}
	public void setDepartmentTitle(String departmentTitle) {
		this.departmentTitle = departmentTitle;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return departmentTitle + " / " + jobName + " / " + employeeName + " / "
				+ email;
	}
}
