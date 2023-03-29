package edu.kh.jdbc.board.model.dto;

import java.util.List;

public class Board {
	
	private int boardNo;			// 게시글 번호
	private String boardTitle;		// 게시글 제목
	private String boardContent;	// 게시글 내용
	private String createDate;		// 작성일
	private int readCount;			// 조회수
	private int memberNo;			// 회원번호(작성자)
	private String memberName;		// 회원 이름
	private int commentCount;		// 댓글 수
	
	private List<Comment> commentList;	//댓글 목록
	
	public Board() {}

	public Board(int boardNo, String boardTitle, String memberName, String createDate,
			int readCount, int commentCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.readCount = readCount;
		this.memberName = memberName;
		this.commentCount = commentCount;
	}




	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	//	BOARD_NO, BOARD_TITLE, MEMBER_NM, CREATE_DT, READ_COUNT, COMMENT_COUNT
	public String getSelectBoard() {
		return String.format("%d | %s[%d] | %s | %s | %d",
				boardNo,boardTitle,commentCount,memberName,createDate,readCount);
	}
	
	
}
