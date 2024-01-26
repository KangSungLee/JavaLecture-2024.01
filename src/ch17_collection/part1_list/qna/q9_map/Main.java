package ch17_collection.part1_list.qna.q9_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0, totalScore = 0;
		
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			totalScore += map.get(key);
			if (map.get(key) > maxScore) {
				maxScore = map.get(key);
				name = key;
				}
		}
		System.out.println("평균점수: " + (double) totalScore / map.size());
		System.out.printf("평균점수: %.1f%n", (double) totalScore / map.size());
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고 점수를 받은 아이디: " + name);
	}
}
