package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;


public class BoardDao {
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// XML에 작성된 SQL을 읽어와 저장할 객체를 참조하는 변수
	private Properties prop;
	
	public BoardDao() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Board> selectAllBoard(Connection conn) throws Exception{
		List<Board> boardList = new ArrayList<>();
		//BOARD_NO, BOARD_TITLE, MEMBER_NM, CREATE_DT, READ_COUNT, COMMENT_COUNT
		String sql = prop.getProperty("selectAllBoard");
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				String createDate = rs.getString("CREATE_DT");
				int readCount = rs.getInt("READ_COUNT");
				int commentCount = rs.getInt("COMMENT_COUNT");
				
				Board board = new Board(boardNo, boardTitle, memberName,
						createDate, readCount, commentCount);
				
				boardList.add(board);
			}
		}
		
		return boardList;
	}

	/** 게시글 상세 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return board
	 * @throws Exception
	 */
	
	public Board selectBoard(Connection conn, int input) throws Exception{
		Board board = null;
		String sql = prop.getProperty("selectBoard");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				String createDate = rs.getString("CREATE_DT");
				int readCount = rs.getInt("READ_COUNT");
				
				String boardContent = rs.getString("BOARD_CONTENT");
				int memberNo = rs.getInt("MEMBER_NO");
				
				board = new Board();
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setMemberName(memberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setBoardContent(boardContent);
				board.setMemberNo(memberNo);
			}
		} finally {
			close(rs);
		}
		return board;
	}

	/**
	 * 조회수 증가 SQL 수행
	 * @param conn
	 * @param input
	 * @return pstmt.executeUpdate()
	 * @throws Exception
	 */
	public int updateReadCount(Connection conn, int input) throws Exception{
		String sql = prop.getProperty("updateReadCount");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, input);
			return pstmt.executeUpdate();
		}
	}

	/** 
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return pstmt.executeUpdate();
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, String boardTitle, String boardContent,
			int boardNo) throws Exception{
		String sql = prop.getProperty("updateBoard");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);
			return pstmt.executeUpdate();
		}
	}

	/**
	 * @param conn
	 * @param boardNo
	 * @return pstmt.executeUpdate()
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception{
		try (PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteBoard"));){
			pstmt.setInt(1, boardNo);
			return pstmt.executeUpdate();
		}
	}

	/** 다음 게시글번호 반환
	 * @param conn
	 * @return rs.getInt(1)
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception{
		try (Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(prop.getProperty("nextBoardNo"))){
			if(rs.next())
				return rs.getInt(1);
		}
		return 0;
	}
	
	/**
	 * @param conn
	 * @param boardNo
	 * @param boardTitle
	 * @param boardContent
	 * @return pstmt.executeUpdate()
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, int boardNo, String boardTitle, String boardContent, int memberNo) throws Exception{
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertBoard"))){
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.setInt(4, memberNo);
			return pstmt.executeUpdate();
		}
	}	
}