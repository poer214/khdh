package edu.kh.project.board.model.dao;

import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;

@Repository // DB관련 + bean 등록(IOC)
public class CommentDAO {
	
	@Autowired	// DI, root-context.xml
	private SqlSessionTemplate sql;

	public List<Comment> select(int boardNo) {
		return sql.selectList("boardMapper.selectCommentList",boardNo);
	}

	public int insert(Comment comment)  throws IllegalStateException, IOException {
		return sql.insert("commentMapper.insert",comment);
	}

	public int delete(int commentNo) {
		return sql.update("commentMapper.delete",commentNo);
	}

	public int update(Comment comment) {
		return sql.update("commentMapper.update",comment);
	}
}
