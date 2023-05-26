package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	List<Map<String, Object>> selectBoardTypeList();

	Map<String, Object> selectBoardList(int boardCode, int cp);

	Board selectBoard(Map<String, Object> map);

	int boardLikeCheck(Map<String, Object> map);

	int like(Map<String, Integer> paramMap);

	int updateReadCount(int boardNo);

	/** 게시글 검색
	 * @param paramMap
	 * @param cp
	 * @return boardList
	 */
	Map<String, Object> selectBoardList(Map<String, Object> paramMap, int cp);
	
	/** 헤더 검색
	 * @param query
	 * @return list
	 */
	List<Map<String, Object>> headerSearch(String query);

	List<String> selectImageList();
}