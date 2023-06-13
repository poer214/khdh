package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // DB 연결 의미 + bean 등록(IOC:제어의역전)
public class AjaxDAO {

	@Autowired
	private AjaxMapper ajaxMapper;

	public String selectNickname(String email) {
		return ajaxMapper.selectNickname(email);
	}

	public String selectMemberTel(String nickname) {
		return ajaxMapper.selectMemberTel(nickname);
	}

	public int checkEmail(String email) {
		return ajaxMapper.checkEmail(email);
	}

	public int checkNickname(String nickname) {
		return ajaxMapper.checkNickname(nickname);
	}

	public Member selectMember(String email) {
		return ajaxMapper.selectMember(email);
	}

	/**이메일이 일부라도 일치하는 모든 회원 조회
	 * @param input
	 * @return memberList
	 */
	public List<Member> selectMemberList(String input) {
		return ajaxMapper.selectMemberList(input);
	}
}