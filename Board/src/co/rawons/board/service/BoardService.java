package co.rawons.board.service;

import java.util.List;

import co.rawons.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList(); //전체리스트
	BoardVO boardSearch(BoardVO vo); //글조회
	int boardInsert(BoardVO vo); // 글쓰기
	int boardDelete(BoardVO vo); // 글삭제

}
