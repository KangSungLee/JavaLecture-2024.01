package q1;

public class 연습문제3번 {

	public static void main(String[] args) {
		
		for (int i = 0; ; i++) {
			if (i % 2 - 1 == 0) {
				continue;
			}
			if (i > 10)
				break;
			
			System.out.println(i);
		}
	}
	
}
