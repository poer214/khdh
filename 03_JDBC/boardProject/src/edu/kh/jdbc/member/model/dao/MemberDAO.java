package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// xml에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	public MemberDAO() { // 기본 생성자로 객체 생성시 XML 읽어오기
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Member> selectMemberList(Connection conn) throws Exception{
		List<Member> results = new ArrayList<>();
		String sql = prop.getProperty("selectMemberList");
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				Member member = new Member();
				String memberId = rs.getString(1);
				String memberName = rs.getString(2);
				String memberGender = rs.getString(3);
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				results.add(member);
			}
		}
		return results;
	}

	/** 회원정보 수정
	 * @param conn
	 * @param memberNo
	 * @param memberName
	 * @param memberGender
	 * @return result;
	 * @throws Exception
	 */
	public int updateMember(Connection conn, int memberNo, String memberName, String memberGender) throws Exception{
		int result = 0;
		String sql = prop.getProperty("updateMember");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 
	 * @param conn
	 * @param inputPw
	 * @param currPw
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(Connection conn, String inputPw, String currPw, int memberNo) throws Exception{
		int result = 0;
		String sql = prop.getProperty("updatePassword");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, inputPw);
			pstmt.setString(2, currPw);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
		}
		return result;
	}

	public int unregisterMember(Connection conn, String memberPw, int memberNo) throws Exception {
		int result = 0;
		String sql = prop.getProperty("unregisterMember");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, memberPw);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		}
		return result;
	}
}