package ch17_collection.part1_list.qna.q7_list;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private List<Board> list = new ArrayList<Board>();

	public BoardDao () {
		this.list.add(new Board("제목1", "내용1"));
		this.list.add(new Board("제목2", "내용2"));
		this.list.add(new Board("제목3", "내용3"));
	}

	public List<Board> getBoardList() {
		return list;
	}
	
	
}
