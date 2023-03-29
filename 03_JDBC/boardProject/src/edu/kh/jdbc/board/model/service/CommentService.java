package edu.kh.jdbc.board.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import edu.kh.jdbc.board.model.dao.CommentDAO;

public class CommentService {
	CommentDAO dao = new CommentDAO();
	
	public int insertComment(String commentContent,int memberNo, int boardNo) throws Exception {
		try(Connection conn = getConnection()){
			int result = dao.insertComment(conn,commentContent,boardNo,memberNo);
			if(result>0) conn.commit();
			else conn.rollback();
			return result;
		}
	}
	public boolean confirmCommentNo(int commentNo, int boardNo, int memberNo) throws Exception{
		try(Connection conn = getConnection()){
			return dao.confirmCommentNo(conn, commentNo, boardNo, memberNo);
		}
	}
	public int updateComment(String commentContent, int commentNo) throws Exception{
		try(Connection conn = getConnection()){
			int result = dao.updateComment(conn,commentContent,commentNo);
			if(result > 0) commit(conn);
			else rollback(conn);
			return result;
		}
	}
	public int deleteComment(int commentNo) throws Exception {
		try(Connection conn = getConnection()){
			int result = dao.deleteComment(conn,commentNo);
			if(result > 0) commit(conn);
			else rollback(conn);
			return result;
		}
	}
}