package edu.kh.project.myPage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {
	
	/** 회원 정보 수정 DAO
	 * @param updateMember
	 * @return
	 */
	public int updateInfo(Member updateMember);
	
	/**
	 * @param memberNo
	 * @return
	 */
	public String selectEncPw(int memberNo);


	/**
	 * @param newPw
	 * @param memberNo
	 * @return
	 */
	public int changePw(Member member);


	public int secession(int memberNo);


	public int updateProfileImage(Member loginMember);
}