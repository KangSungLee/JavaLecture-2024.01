package ch05_reference;

import java.util.Arrays;

public class Ex01_Array {

	public static void main(String[] args) {
		// 단점. 동일한 자료형 생성시 크기(저장공간)를 지정 후 변경x
		// 장점. 차례대로 메모리가 들어가 있다.
		// . 엑세스 하기 편하고 데이터 처리속도가 빠르다

		// 배열을 생성하면서 값을 지정하는 경우
		int[] score = { 80, 90, 78, 93, 65 }; // 어레이 생성 방법1
		char greade[] = { 'B', 'A', 'C', 'A', 'D' }; // 어레이 생성 방법2

		// 배열을 생성하면서 크기를 지정하는 경우
		int[] newArray = new int[10];

		// 배열 인덱싱
		System.out.println(score[0] + ", " + score[4]);
		for (int i = 0; i < score.length; i++)
			System.out.print(score[i] + " ");
		System.out.println();

		// 값을 할당
		score[0] = 90;
		greade[0] = 'A';

		for (int i = 0; i < newArray.length; i++)
			newArray[i] = 1 + (int) (Math.random() * 6);
		System.out.println(Arrays.toString(newArray));
		// **외우기 [6, 2, 4, 2, 6, 3, 6, 1, 3, 3]으로나옴
		System.out.println(Arrays.toString(score));
		System.out.println(Arrays.toString(greade));
	}

}
