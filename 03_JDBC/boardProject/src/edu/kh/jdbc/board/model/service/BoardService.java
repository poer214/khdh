package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.BoardDao;
import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Comment;

public class BoardService {
	private BoardDao dao = new BoardDao();
	private CommentDAO commentDao = new CommentDAO();
	
	/** 게시글 목록 조회 서비스
	 * 
	 * @return dao.selectAllBoard(conn);
	 * @throws Exception
	 */
	public List<Board> selectAllBoard() throws Exception{
		try(Connection conn = getConnection()){
			return dao.selectAllBoard(conn);
		}
	}

	/** 게시글 상세 조회 서비스
	 * @param input
	 * @param memberNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int input, int memberNo) throws Exception{
		// 1. 커넥션 생성
		try(Connection conn = getConnection();){
			// 2. 게시글 상세 조회 DAO 메서드 호출
			Board board = dao.selectBoard(conn, input);
			// 3.  게시글이 조회된 경우
			if(board != null) {
				
				// *******************************************************************
				// ** 해당 게시글에 대한 댓글 목록 조회 DAO 호출
				List<Comment> commentList = commentDao.selectCommentList(conn, input);
				
				// board에 commentList 추가
				board.setCommentList(commentList);
				// *******************************************************************
				
				
				
				
				// 4. 조회수 증가
				// 단, 게시글 작성자와 로그인한 회원이 다를 경우
				if(board.getMemberNo() != memberNo) {
					// 조회한 게시글 회원 번호 != 로그인한 회원 번호
					
					// 5. 조회수 증가 DAO 메서드 호출(UPDATE)
					int result = dao.updateReadCount(conn, input);
					
					// 6. 트랜잭션 제어 처리 + 데이터 동기화 처리
					if(result > 0) {
						commit(conn);
						// 조회된 board의 조회수 0
						// DB의 조회수는 1
						board.setReadCount(board.getReadCount()+1);
					} else
						rollback(conn);
				}
			}
			return board;
		}
	}

	/** d
	 * @param boardTitle
	 * @param string
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int updateBoard(String boardTitle, String boardContent, int boardNo) throws Exception{
		try (Connection conn = getConnection();){
			int result = dao.updateBoard(conn,boardTitle,boardContent,boardNo);
			if(result > 0) commit(conn);
			else rollback(conn);
			return result;
		}
	}

	/**
	 * @param boardNo
	 * @return 
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception{
		try(Connection conn = getConnection()){
			int result = dao.deleteBoard(conn,boardNo);
			if(result > 0) commit(conn);
			else rollback(conn);
			
			return result;
		}
	}

	/** 게시글 삽입 서비스
	 * @param boardTitle
	 * @param string
	 * @param memberNo
	 * @return boardNo
	 * @throws Exception
	 */
	public int insertBoard(String boardTitle, String boardContent, int memberNo) throws Exception{
		try(Connection conn = getConnection()){
			int boardNo = dao.nextBoardNo(conn);
			int result = dao.insertBoard(conn,boardNo,boardTitle,boardContent,memberNo);
			if(result >0) {
				commit(conn);
				return boardNo;
			}
			rollback(conn);
			return result;
		}
	}
}