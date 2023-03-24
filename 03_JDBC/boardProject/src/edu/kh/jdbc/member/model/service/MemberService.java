package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	
	public List<Member> selectMemberList() throws Exception{
		try(Connection conn = getConnection()){
			return dao.selectMemberList(conn);
		}
	}
}
