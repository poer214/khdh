package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {
	public List<Employee2> select(String input){
		List<Employee2> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			String user = "kh_ldh";
			String pw = "oracle_ldh123A";
			
			conn = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT DEPT_TITLE, JOB_NAME, EMP_NAME, EMAIL "
					+ "FROM EMPLOYEE "
					+ "LEFT NATURAL JOIN JOB "
					+ "LEFT JOIN DEPARTMENT D ON(DEPT_CODE=DEPT_ID) "
					+ "WHERE JOB_NAME = '"+input+"' "
					+ "ORDER BY EMP_NAME";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String departmentTitle = rs.getString(1);
				String jobName = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				
				list.add(new Employee2(departmentTitle, jobName, name, email));
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("지정된 경로에 클래스가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
