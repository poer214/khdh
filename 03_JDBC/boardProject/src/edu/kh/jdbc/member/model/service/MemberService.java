package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	
	public List<Member> selectMemberList() throws Exception{
		try(Connection conn = getConnection()){
			return dao.selectMemberList(conn);
		}
	}
	
	
	/**
	 * 
	 * @param memberId
	 * @param memberName
	 * @param memberGender
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(int memberNo, String memberName, String memberGender) throws Exception{
		Connection conn = getConnection();
		int result = dao.updateMember(conn, memberNo, memberName, memberGender);
		if(result > 0) commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}


	public int updatePassword(String inputPw, String currPw, int memberNo) throws Exception{
		Connection conn = getConnection();
		int result = dao.updatePassword(conn, inputPw, currPw, memberNo);
		if(result > 0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public String createSecurityCode() {
		StringBuffer code = new StringBuffer();
		
		// String : 불변성
		// StringBuffer : 가변성
		
		Random random = new Random();
		
		for(int i =0;i<6;i++) {
			int x= random.nextInt(10);
			code.append(x);
		}
		
		return code.toString();
	}


	public int unregisterMember(String memberPw, int memberNo) throws Exception{
		Connection conn = getConnection();
		int result = dao.unregisterMember(conn, memberPw, memberNo);
		if(result > 0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}