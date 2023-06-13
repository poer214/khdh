package edu.kh.project.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDAO {
	@Autowired
	private EmailMapper emailMapper;

	public int updateAuthKey(Map<String, String> map) {
		return emailMapper.updateAuthKey(map);
	}

	public int insertAuthKey(Map<String, String> map) {
		return emailMapper.insertAuthKey(map);
	}

	public int checkAuthKey(Map<String, Object> paramMap) {
		return emailMapper.checkAuthKey(paramMap);
	}
}