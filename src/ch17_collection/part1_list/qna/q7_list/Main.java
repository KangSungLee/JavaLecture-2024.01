package ch17_collection.part1_list.qna.q7_list;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for (Board b: list)
			System.out.println(b);

	}

}
