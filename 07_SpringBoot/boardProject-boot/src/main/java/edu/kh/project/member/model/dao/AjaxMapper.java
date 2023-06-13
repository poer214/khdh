package edu.kh.project.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {
	String selectNickname(String email);
	String selectMemberTel(String nickname);
	int checkEmail(String email);
	int checkNickname(String nickname);
	Member selectMember(String email);
	List<Member> selectMemberList(String input);
}
