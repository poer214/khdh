package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO(Data Access Object) : DB 접근용 객체
public class EmployeeDAO {
	
	// JDBC 구문이 여러 번 작성될 예정
	// -> JDBC 객체 참조 변수가 계속 작성될 예정
	//    -> 필드로 작성하여 재사용
	
	private Statement stmt;
	private ResultSet rs;
	
	
	
	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드 
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {
		
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
			
			// 1) SQL 작성
			// 
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'없음') DEPT_TITLE, "
					+ "JOB_NAME, NVL(PHONE,'없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "NATURAL JOIN JOB "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) "
					+ "ORDER BY JOB_CODE";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString("PHONE");
				
				Employee emp = new Employee(Integer.parseInt(empId), empName, deptTitle, jobName, phone);
				
				empList.add(emp);
			}
		} finally {
			// catch문 -> throws 구문으로 예외 처리
			
			// 4. JDBC 객체 자원 반환(단, conn 빼고)
			close(rs);
			close(stmt);
		}
		
		// 5. 결과 반환
		return empList;
	}


	/** 사원 1명 정보 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input 
	 * @return emp
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException{
		
		// 1. 결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		// -> 조회 결과가 있을 경우에 객체 생성
		
		try {
			// 2. SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'없음') DEPT_TITLE, "
					+ "JOB_NAME, NVL(PHONE,'없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "NATURAL JOIN JOB "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) "
					+ "WHERE EMP_ID = " + input;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과가 있는 지 확인 후
			// 있으면 Employee 객체 생성 후 emp에 대입
			if(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				// DB에서 값을 얻어올 때
				// "숫자" (문자열로 된 숫자) 형태일 경우
				// getInt()를 작성하면 자동으로 int 형변환 진행
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString("PHONE");
				emp = new Employee(empId, empName, deptTitle, jobName, phone);
			}
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 뺴고)
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return emp;
	}

	/** 
	 * @param conn
	 * @param input 
	 * @return empList
	 */
	public List<Employee> selectName(Connection conn, String input) throws SQLException {
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		// -> 조회 결과가 있을 경우에 객체 생성

		try {
			// 2. SQL 작성
				String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'없음') DEPT_TITLE, "
						+ "JOB_NAME, NVL(PHONE,'없음') PHONE "
						+ "FROM EMPLOYEE "
						+ "NATURAL JOIN JOB "
						+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) "
						+ "WHERE EMP_NAME like '%%"+input+"%%' "
						+ "ORDER BY EMP_ID";
					
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
					
				// 3. 조회 결과가 있는 지 확인 후
				// 있으면 Employee 객체 생성 후 emp에 대입
				while (rs.next()) {
					int empId = rs.getInt("EMP_ID");
					String empName = rs.getString("EMP_NAME");
					String deptTitle = rs.getString("DEPT_TITLE");
					String jobName = rs.getString("JOB_NAME");
					String phone = rs.getString("PHONE");
					empList.add(new Employee(empId, empName, deptTitle, jobName, phone));
				}
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 뺴고)
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return empList;
	}
	
	/**
	 * @param conn
	 * @param a
	 * @param b
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> selectSalaryBetween(Connection conn, int a, int b) throws SQLException {
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		// -> 조회 결과가 있을 경우에 객체 생성
		try {
		// 2. SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'없음') DEPT_TITLE, SALARY \r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID)\r\n"
					+ "WHERE SALARY BETWEEN "+a+" AND "+b+" "
					+ "ORDER BY SALARY";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 3. 조회 결과가 있는 지 확인 후
			// 있으면 Employee 객체 생성 후 emp에 대입
			while (rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				int salary = rs.getInt("SALARY");
				empList.add(new Employee(empId, empName, deptTitle, salary));
			}
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 뺴고)
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return empList;
	}
}
