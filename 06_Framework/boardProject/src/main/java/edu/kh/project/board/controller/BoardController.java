package edu.kh.project.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.service.BoardService;


@SessionAttributes({"loginMember"})
@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	/* 목록 조회 : /board/1?cp=1 (cp : current page(현재 페이지))
	 * 상세 조회 : /board/1/1500?cp=1
	 * 
	 * ** 컨트롤러 따로 생성 예정
	 * 삽입 : /board2/insert?code=1 (code == BOADE_CODE, 게시판 종류)
	 * 수정 : /board2/update?code=1&no=1500 (no == BOARD_NO, 게시판 번호)
	 * 삭제 : /board2/delete?code=1&no=1500 (
	 */
	
	// @PathVariable
	// URL 경로에 있는 값을 매개 변수로 이용할 수 있게 하는 어노테이션
	// + request scope에 세팅
	
	// @PathVariable을 사용하는 경우
	// - 자원(resource) 구분/식별
	// ex) github.com/baekdh0206
	// ex) github.com/testUser
	// ex) /board/1 -> 1번(공지사항) 게시판
	// ex) /board/2 -> 2번(자유 게시판) 게시판
	
	// QueryString을 사용하는 경우
	// - 정렬, 필터링
	// ex) search.naver.com?query=날씨
	// ex) search.naver.com?query=점심
	// ex) /board2/insert?code=1
	// ex) /board2/insert?code=2
	//	  -> 삽입이라는 공통된 동작 수행
	//		단, code에 따라 어디에 삽입할 지 지정(필터링)
	
	// ex) /board/list?order=recent (최신순 정렬)
	// ex) /board/list?order=most (인기순 정렬)
	
	
	
	// 게시글 목록 조회
	@GetMapping("/{boardCode}")
	public String selectBoardList(
			@PathVariable("boardCode")int boardCode,
			// required true인데 cp 없으면 400에러
			// defaultValue있으면 항상 있기때문에 required true든 false든 무의미
			@RequestParam(value="cp", required=true, defaultValue="1")int cp,
			Model model
			) {
		
		// boardCode 확인
		System.out.println("boardCode : "+boardCode);
		
		// 게시글 목록 조회 서비스 호출
		Map<String,Object> map = service.selectBoardList(boardCode, cp);
		
		model.addAttribute("map",map);
		
		System.out.println(map);
		
		return "board/boardList";
	}
}