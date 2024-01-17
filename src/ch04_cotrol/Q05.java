package ch04_cotrol;

public class Q05 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 5; i++)
			for (int k = 0; k < 3; k++) {
				if (i == 2) {
					continue;
				}
				if (k == 1) {
					
					break;
				}
				System.out.println("A");
				count++;
			}
		System.out.println(count + "회");
	}
	
}
