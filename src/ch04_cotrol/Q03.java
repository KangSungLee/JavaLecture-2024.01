package ch04_cotrol;

public class Q03 {

	public static void main(String[] args) {
		for (int i = 0; ; i++) {
			if(i > 10)
				break;
			if (i % 2 == 1)
				continue;
			System.out.println(i); // 0 2 4 6 8 10
		}
		for (int i = 0; i <= 10 ; i+=2) {
			System.out.println(i);
		}

	}

}
