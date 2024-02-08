package mysql.sec07_bbs.appl;

import java.util.List;

import mysql.sec07_bbs.entity.Board;
import mysql.sec07_bbs.service.BoardServiceMySQLImpl;
import mysql.sec07_bbs.service.BoardServies;

public class BoardAPPI {

	public static void main(String[] args) {
		BoardServies bSvc = new BoardServiceMySQLImpl();
		
		List<Board> list = bSvc.getBoardList(1, "", "");
		list.forEach(x -> System.out.println(x.listForm()));
		System.out.println("========================================================");
		
		Board board = bSvc.getBoard(18);
		System.out.println(board);
		if(board.getReplyList() != null) {
			board.getReplyList().forEach(x -> System.out.println(x));
		}
		
		bSvc.close();
	}

}
