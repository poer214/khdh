package edu.kh.jdbc.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public List<Emp> selectEntN(Connection conn) throws SQLException {
		List<Emp> results = new ArrayList<>();
		String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "NATURAL JOIN JOB\r\n"
				+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
				+ "WHERE ENT_YN = 'N'\r\n"
				+ "ORDER BY EMP_ID";
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Emp emp = new Emp();
				emp.setSelectEntN(empId, empName, deptTitle, jobName,
						salary, phone, email);
				results.add(emp);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return results;
	}
	
	public List<Emp> selectEntY(Connection conn) throws SQLException {
		List<Emp> results = new ArrayList<>();
		
		String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, ENT_DATE\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "WHERE ENT_YN = 'Y'\r\n"
				+ "ORDER BY ENT_DATE";
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				Emp emp = new Emp();
				emp.setSelectEntY(empId, empName, phone, email, entDate);
				results.add(emp);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return results;
	}

	public Emp selectEmpId(Connection conn, int input) throws SQLException{
		Emp result = null;
		String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'없음') DEPT_TITLE, "
				+ "JOB_NAME, SALARY, NVL(PHONE,'없음') PHONE, EMAIL, HIRE_DATE, ENT_YN "
				+ "FROM EMPLOYEE "
				+ "NATURAL JOIN JOB "
				+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) "
				+ "WHERE EMP_ID = " + input;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entYN = rs.getString(9);
				result = new Emp();
				result.setSelectEmpId(empId, empName, deptTitle,
						jobName, salary, phone, email, hireDate, entYN);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return result;
	}

	public int insertEmp(Connection conn, Emp emp) throws SQLException{
		int result=0;
		String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			result = pstmt.executeUpdate();
		}
		return result;
	}
	
	public int updateEmpId(Connection conn, Emp emp) throws SQLException{
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	PHONE = ?,\r\n"
					+ "	SALARY = ?,\r\n"
					+ "	BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteEmpId(Connection conn, int input) throws SQLException{
		int result = 0;
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, input);
			result = pstmt.executeUpdate();
		}
		return result;
	}
	
	public int retireEmpId(Connection conn, int input) throws SQLException{
		int result = 0;
		String sql = "UPDATE EMPLOYEE\r\n"
				+ "SET ENT_YN = 'Y',\r\n"
				+ "	ENT_DATE = SYSDATE\r\n"
				+ "WHERE EMP_ID = "+input;
		try (Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		}
		return result;
	}

	public List<Emp> selectFiveMostRecentlyHiredEmployees(Connection conn)
	throws SQLException{
		List<Emp> results = new ArrayList<>();
		String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE\r\n"
				+ "FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)\r\n"
				+ "ORDER BY HIRE_DATE DESC)\r\n"
				+ "WHERE ROWNUM <=5";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				Date hireDate = rs.getDate(4);
				Emp emp = new Emp();
				emp.setSelectFiveMostRecentlyHiredEmployees(empId, empName, departmentTitle, hireDate);
				results.add(emp);
			}
		}
		return results;
	}

	public List<Map<String,Object>> selectStatisticsByDepartment(Connection conn)
	throws SQLException{
		List<Map<String,Object>> results = new ArrayList<>(); 
		String sql = "SELECT DEPT_TITLE, COUNT(*), AVG(SALARY)\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE)\r\n"
				+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
				+ "ORDER BY DEPT_CODE";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			int count = 0;
			while (rs.next()) {
				String deptTitle = rs.getString(1);
				int person = rs.getInt(2);
				double avg = rs.getDouble(3);

				Map<String,Object> map = new LinkedHashMap();
				map.put("deptTitle", deptTitle);
				map.put("person", person);
				map.put("avg", avg);
				
				results.add(map);
				
			}
		}
		return results;
	}
}