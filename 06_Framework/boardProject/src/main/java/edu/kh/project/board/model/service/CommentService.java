package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;

import edu.kh.project.board.model.dto.Comment;

public interface CommentService {

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return cList
	 */
	List<Comment> select(int boardNo);

	/** 댓글 작성
	 * @param comment
	 * @return result
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	int insert(Comment comment) throws IllegalStateException, IOException ;

	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 */
	int delete(int commentNo);

	/** 댓글 수정
	 * @param comment
	 * @return result
	 */
	int update(Comment comment);
}