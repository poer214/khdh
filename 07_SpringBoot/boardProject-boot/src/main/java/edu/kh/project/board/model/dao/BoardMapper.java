package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

   /** 게시판 종류 조회
    * @return boardTypeList
    */
   List<Map<String, Object>> selectBoardTypeList();
   
   
   /** 특정 게시판의 삭제되지 않은 게시글 수 조회
    * @param boardCode
    * @return listCount
    */
   int getListCount(int boardCode);

   /** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
    * @param pagination
    * @param boardCode
    * @return
    */
   List<Board> selectBoardList(int boardCode, RowBounds rowbounds);

   
   /** 게시글 상세 조회
    * @param map
    * @return board
    */
   Board selectBoard(Map<String, Object> map);

   /** 좋아요 여부 확인 서비스
    * @param map
    * @return result
    */
   int boardLikeCheck(Map<String, Object> map);

   /** 좋아요 테이블 삽입
    * @param paramMap
    * @return result
    */
   int insertBoardLike(Map<String, Integer> paramMap);
   
   /** 좋아요 테이블 삭제
    * @param paramMap
    * @return result
    */
   int deleteBoardLike(Map<String, Integer> paramMap);

   /** 좋아요 개수 조회
    * @param boardNo
    * @return count
    */
   int countBoardLike(Integer boardNo);

   
   /** 조회 수 증가
    * @param boardNo
    * @return result
    */
   int updateReadCount(int boardNo);

   /** 게시글 수 조회(검색)
    * @param paramMap
    * @return listCount
    */
   int getSearchListCount(Map<String, Object> paramMap);

   /** 게시글 목록 조회(검색)
    * @param pagination
    * @param paramMap
    * @return boardList
    */
   List<Board> selectSearchBoardList(Map<String, Object> paramMap, RowBounds rowBounds);
   
   /** 헤더 검색
    * @param query
    * @return list
    */
   List<Map<String, Object>> headerSearch(String query);

   
   /** DB 이미지(파일) 목록 조회
    * @return list
    */
   List<String> selectImageList();
}