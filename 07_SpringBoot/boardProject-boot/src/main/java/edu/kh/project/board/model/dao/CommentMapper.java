package edu.kh.project.board.model.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Comment;

@Mapper
public interface CommentMapper {

	public List<Comment> select(int boardNo);

	public int insert(Comment comment)  throws IllegalStateException, IOException;

	public int delete(int commentNo);

	public int update(Comment comment);
}
