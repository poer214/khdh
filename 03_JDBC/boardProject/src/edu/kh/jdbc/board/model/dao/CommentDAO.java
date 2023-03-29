package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;

public class CommentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(
			Connection conn, int input) throws Exception {
		
		// 결과 저장용 객체 생성
		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectCommentList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return commentList;
	}

	public int insertComment(Connection conn, String commentContent, int memberNo, int boardNo) throws Exception {
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertComment"));){
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			return pstmt.executeUpdate();
		}
	}
	public boolean confirmCommentNo(Connection conn, int commentNo, int boardNo, int memberNo) throws Exception{
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("confirmCommentNo"))){
			pstmt.setInt(1, commentNo);
			pstmt.setInt(2, boardNo);
			pstmt.setInt(3, memberNo);
			return pstmt.executeQuery().next();
		}
	}
	public int updateComment(Connection conn, String commentContent, int commentNo) throws Exception{
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateComment"))){
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNo);
			return pstmt.executeUpdate();
		}
	}
	public int deleteComment(Connection conn, int commentNo) throws Exception{
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteComment"))){
			pstmt.setInt(1, commentNo);
			return pstmt.executeUpdate();
		}
	}
}