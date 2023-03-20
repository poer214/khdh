package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBCExample0 {
	public static void main(String[] args) {

//		List<DTO> list = select(new Scanner(System.in).next());
		
		
//		for(DTO d:list)
//			System.out.println(d);
		

	}

	public List<Object> select(String input) {
		List<Object> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_ldh";
			String pw = "oracle_ldh123A";

			conn = DriverManager.getConnection(type + ip + port + dbName, user, pw);
			String sql = "";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
//				int 변수명 = rs.getInt(0);
//				Date 변수명 = rs.getDate(0);
//				String 변수명 = rs.getString(0);

				String a = rs.getString(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				String d = rs.getString(4);

//				list.add(new DTO(a,b,c,d));
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
