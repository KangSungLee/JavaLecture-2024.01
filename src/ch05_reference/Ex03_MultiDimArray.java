package ch05_reference;

import java.util.Arrays;

public class Ex03_MultiDimArray {

	public static void main(String[] args) {
		// 2차원 배열 (matrix)
		int[][] matrix = new int[2][3];
		int score[][] = { { 80, 90, 70 }, { 85, 88, 72 } };
		System.out.println(Arrays.toString(score)); // 도움이 안됨
		System.out.println(Arrays.toString(score[0]));
		System.out.println(Arrays.toString(score[1]));

		// 인덱싱
		System.out.println(score[0][0] + "," + score[1][1]);

		// 톱니바퀴 모양도 가능 (쓸일은 없다)
		int gear[][] = { { 1, 3, 5, 9 }, { 2, 6 }, { 8, 5, 3 } };

		// 실력향상 연습문제
		// 두 행렬의 dot product 구해보기
		int[][] a = {{1, 2, 3}, {4, 5, 6}};	// 2x3
		int[][] b = {{1, 2}, {3, 4}, {5, 6}}; // 3x2
		int[][] c = new int[2][2];
		
		// 지뢰찾기
		char[][] mines = new char[8][8];
		for(int i = 0; i < mines.length; i++) {		//지뢰판만들기
			for (int k = 0; k < mines[i].length; k++) {		
				mines[i][k] = (Math.random() > 0.7 ? '*' : '.');
			}
		}
		printMines(mines);
	}
	static void printMines(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for(int k = 0; k <arr[i].length; k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}
	}
}
// 지뢰찾기
// 안보이는 공간에 1행 1열을 추가(padding)를 하고 8공간을 탐색하면 좀 더 쉬워짐
