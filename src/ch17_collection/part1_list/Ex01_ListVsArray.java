package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01_ListVsArray {

	public static void main(String[] args) {
		String[] array = "가나다라마바사".split("");
		System.out.println(Arrays.toString(array));
		
		List<String> list = new ArrayList<String>(); // 구현객체(ArrayList)에 있는 <String>에서 생략가능
		// 뒤쪽 스트링은 생략해도됨 앞에서 스트링으로 선언 했기 때문에
		list.add("가"); list.add("나"); list.add("다"); list.add("라");
		list.add("마"); list.add("바"); list.add("사");
//		for (String element: list)
//			System.out.print(element + " "); 	// 출력 방법1
//		System.out.println();
//		list.forEach(x -> System.out.print(x + " "));	// 출력 방법2
//		System.out.println();
		System.out.println(list);
		
		// 삭제
		array[2] = null; array[5] = null;
		System.out.println(Arrays.toString(array));
		
		list.remove("다"); list.remove("바");
		list.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		// 삭제 후 크기 비교
		System.out.println(array.length + ", " + list.size());	
		// length 와 size 는 같은기능
		
		// 추가(삽입)
		list.add("아"); list.add("자"); list.add("차");
		list.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		// 추가후 크기
		System.out.println(list.size());
		System.out.println(list);
	}

}
