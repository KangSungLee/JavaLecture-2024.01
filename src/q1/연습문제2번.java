package q1;

public class 연습문제2번 {

	public static void main(String[] args) {

		int score = 72;

		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			
			break;
		default:
			System.out.println("F학점");

		}
	}
	
}