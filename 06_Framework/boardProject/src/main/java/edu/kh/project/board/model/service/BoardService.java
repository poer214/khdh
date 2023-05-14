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
}