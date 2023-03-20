package edu.kh.jdbc.run;

import static edu.kh.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TWRTestRun {
	public static void main(String[] args) {
		String sql = "SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE";
		try (Connection conn = getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				System.out.printf("%s / %s / %d\n", empId, empName, salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}