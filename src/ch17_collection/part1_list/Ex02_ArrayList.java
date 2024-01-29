package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch17_collection.part2_set.sec12_member.Member;

public class Ex02_ArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();		// 대부분 이렇게 사용한다
		ArrayList<String> aList = new ArrayList<>();// 이렇게는 잘 사용하지 않음
		
		list.add("class"); list.add("interface"); list.add("inheritance");
		System.out.println(list);
		
		// 정적 리스트
		List<String> fruitList = Arrays.asList(new String[] {"apple","banana", "cherry"});
		System.out.println(fruitList);
//		fruitList.add("mango");		// 정적인 리스트는 추가/삭제가 안됨 잘사용되지않음
		
		// 프리미티브 타입은 Wrapper 클래스로 리스트를 생성해야 함 //정수 리스트
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1); numList.add(3); numList.add(5);		//add 추가
		System.out.println(numList);
		
		// 추출(인덱싱)	.get
		System.out.println(list.get(1));
						
		// 데이터 추가
		list.add("list");		// 맨 뒤에 추가
		list.add(3, "collection");	//3번인덱스 앞으로추가, 내가원하는 공간으로 추가
		System.out.println(list);	
		list.addAll(fruitList);	// 맨 뒤에 컬렉션 추가
		System.out.println(list);
		
		// 데이터 변경
		list.set(5, "setttt");	// set 값 변경
		System.out.println(list);
		
		// 데이터 삭제 // 자바가 오버로딩을 지원하기 때문에
		list.remove(6);				// 6번 인덱스 값 삭제
		list.remove("cherry");		// 체리 엘리먼트 삭제
		System.out.println(list);
		numList.clear();				// 리스트 전체 원소 삭제
		System.out.println(numList);
		
		// 정보 추출
		System.out.println(numList.isEmpty() + ", " + numList.size());
		System.out.println(list.contains("setttt"));	// setttt란 단어가 있는지 
		System.out.println(list.indexOf("list"));	// list란 단어가 몇번째 있는지 없으면 -1		
	}

}
