package q1.Q1;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	List<Board> list = new ArrayList<Board>();

	public List<Board> getBoardList() {
		for (int i = 1; i <= 3; i++) {
			list.add(new Board("제목" + i, "내용" + i));
		}
		return list;
	}
}
