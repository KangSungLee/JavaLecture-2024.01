package q1;

public class 연습문제5번 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			for (int k = 0; k < 3; k++) {
				if (i == 2) {
					continue;
				}
				if (k == 1) {
					
					break;
				}
				System.out.println("A");
			}
	}
	
}

//i k
//0 0 출력
//0 1 b
//1 0 출력
//1 1 b
//2 0 c
//3 0 출력
//3 1 b
//4 0 출력
//4 1 b