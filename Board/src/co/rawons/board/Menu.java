package co.rawons.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.rawons.board.service.BoardService;
import co.rawons.board.serviceImpl.BoardServiceImpl;
import co.rawons.board.vo.BoardVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();

	private void menuTitle() {
		System.out.println("========<<<전체목록>>>========");
		boardsList();
		System.out.println("=======1.글쓰기========");
		System.out.println("=======2.글조회========");
		System.out.println("=======3.글삭제========");
		System.out.println("========4.종료========");
		System.out.println("==원하는 작업번호를 선택하세요>>>");
	}

	private void mainMenu() {
		int selectNo;
		boolean b = false;
		do {
			menuTitle();
			switch (selectNo = sc.nextInt()) {
			case 1:
				boardInsert();
				break;
			case 2:
				boardSearch();
				break;
			case 3:
				boardDelete();
				break;
			case 4:
				b = true;
				System.out.println("== 종료되었습니다. ==");
				break;
			}
		} while (!b);

	}

	private void boardsList() {
		// TODO 전체목록
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = dao.boardList();
		for (BoardVO board : boards) {
			board.toString();
		}

	}

	private void boardDelete() {
		// TODO 글삭제
		BoardVO vo = new BoardVO();
		System.out.println("삭제할 id입력>>>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("정상적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제실패!!!");
		}
	}

	private void boardInsert() {
		// TODO 글쓰기
		BoardVO vo = new BoardVO();
		System.out.println("id입력>>>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		System.out.println("작성자 입력>>>");
		vo.setWriter(sc.next());
		sc.nextLine();
		System.out.println("제목입력>>>");
		vo.setTitle(sc.next());
		sc.nextLine();
		System.out.println("내용입력>>>");
		vo.setSubject(sc.next());

		int n = dao.boardInsert(vo);
		if (n != 0) {
			System.out.println("정상적으로 입력되었습니다.");
		} else {
			System.out.println("입력실패!!!");
		}
	}

	private void boardSearch() {
		// TODO 글조회
		BoardVO vo = new BoardVO();
		System.out.println("검색할 id입력>>>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		vo = dao.boardSearch(vo);
		System.out.println("작성자: " + vo.getWriter() + ", 글내용: " + vo.getSubject());

	}

	public void run() {
		mainMenu();
		sc.close();

	}

}
