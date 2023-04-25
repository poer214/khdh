package edu.kh.project.member.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.project.member.model.dto.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		 try{
			 prop = new Properties();
			 
			 String filePath = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			 
			 prop.loadFromXML(new FileInputStream(filePath));
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	
	}

	/** 로그인처리
	 * @param conn
	 * @param inputEmail
	 * @param inputPw
	 * @return
	 * @throws Exception
	 */
	public Member login(Connection conn, String inputEmail, String inputPw) throws Exception {
		try ( PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("login")); ){
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, inputPw);
			try( ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) return new Member(rs.getInt(1),rs.getString(2),null,rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),null,rs.getInt(7));
				
				else return null;
			}
		}
	}
}