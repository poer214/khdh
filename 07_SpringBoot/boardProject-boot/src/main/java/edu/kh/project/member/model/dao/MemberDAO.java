package edu.kh.project.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper memberMapper; // MemberMapper 인터페이스를 상속 받은 자식 객체
									   // -> 자식 객체가 sqlSessionTemplate을 이용
	
	
	/** 로그인
	 * @param inputMember
	 * @return loginMember
	 */
	public Member login(Member inputMember) {
		return memberMapper.login(inputMember);
	}


	public int signUp(Member inputMember) {
		return memberMapper.signUp(inputMember);
	}
}
