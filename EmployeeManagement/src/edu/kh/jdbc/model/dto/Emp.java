package edu.kh.jdbc.model.dto;

import java.sql.Date;

public class Emp {
	private int empId; 		// 사원 번호(사번)
	private String empName; // 사원 이름
	private String empNo; 	// 주민등록번호
	private String email; 	// 이메일
	private String phone; 	// 전화번호
	private int salary; 	// 급여
	private String deptCode; // 부서코드
	private String jobCode; // 직급코드
	private String salLevel; // 급여등급
	private double bonus; // 보너스
	private int managerId; // 사수번호
	private Date hireDate; // 입사일
	private String entYN;  // 퇴직여부
	private String entDate; // 퇴사일
	
	private String departmentTitle; // 부서명
	private String jobName; // 직급명
	
	public Emp() { }
	public Emp(String empName, String empNo, String email, String phone, int salary, String deptCode,
			String jobCode, String salLevel, double bonus, int managerId) {
		super();
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.bonus = bonus;
		this.managerId = managerId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getEntYN() {
		return entYN;
	}

	public void setEntYN(String entYN) {
		this.entYN = entYN;
	}

	public String getEntDate() {
		return entDate;
	}

	public void setEntDate(String entDate) {
		this.entDate = entDate;
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

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email + ", phone="
				+ phone + ", salary=" + salary + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel="
				+ salLevel + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate + ", entYN="
				+ entYN + ", entDate=" + entDate + ", departmentTitle=" + departmentTitle + ", jobName=" + jobName
				+ "]";
	}

	public String toSelectEntN() {
		// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
		return String.format("%d / %s / %s / %s / %,d / %s / %s",
				empId,empName,departmentTitle,jobName,salary,phone,email);
	}
	
	public void setSelectEntN(int empId, String empName, String departmentTitle,
			String jobName, int salary, String phone, String email) {
		this.empId = empId;
		this.empName = empName;
		this.departmentTitle = departmentTitle;
		this.jobName = jobName;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
	}
	
	public String toSelectEntY() {
		return String.format("%d / %s / %s / %s / %s",
				empId, empName, phone, email, entDate);
	}
	
	public void setSelectEntY(int empId, String empName, String phone,
			String email, String entDate) {
		this.empId = empId;
		this.empName = empName;
		this.phone = phone;
		this.email = email;
		this.entDate = entDate;
	}

	public String toSelectEmpId() {
//		사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
		return String.format("%d / %s / %s / %s / %,d / %s / %s / %s / %s",
				empId, empName, departmentTitle, jobName, salary, phone, email,
				hireDate, entYN);
	}
	
	public void setSelectEmpId(int empId, String empName, String departmentTitle,
			String jobName, int salary, String phone, String email, Date hireDate,
			String entYN) {
		this.empId = empId;
		this.empName = empName;
		this.departmentTitle = departmentTitle;
		this.jobName = jobName;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
		this.hireDate = hireDate;
		this.entYN = entYN;
	}
	public String toSelectFiveMostRecentlyHiredEmployees() {
		return String.format("%d / %s / %s / %s",empId,empName,departmentTitle,hireDate);
	}
	
	public void setSelectFiveMostRecentlyHiredEmployees(
			int empId,String empName,String departmentTitle,Date hireDate) {
		this.empId = empId;
		this.empName = empName;
		this.departmentTitle = departmentTitle;
		this.hireDate = hireDate;
	}
}