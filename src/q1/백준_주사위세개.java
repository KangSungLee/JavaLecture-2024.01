package q1;

public class 백준_주사위세개 {

	public static void main(String[] args) {
//		같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
//		같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
//		모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다
		int dice1 = 1 + (int) (Math.random() * 6);
		int dice2 = 1 + (int) (Math.random() * 6);
		int dice3 = 1 + (int) (Math.random() * 6);
		
		System.out.println(dice1 + ", " + dice2 + ", " + dice3);
		if (dice1 == dice2 && dice1 == dice3) {
			System.out.println(10000 + dice1 * 1000);
		} else if (dice1 == dice2 || dice1 == dice3) {
			System.out.println(1000 + dice1 * 100);
		} else if (dice2 == dice3) {
			System.out.println(1000 + dice2 * 100);
		} else if (dice1 > dice2 && dice1 > dice3) {
			System.out.println(dice1 * 100);
		} else if (dice2 > dice1 && dice2 > dice3) {
			System.out.println(dice2 * 100);
		} else {
			System.out.println(dice3 * 100);
		}
	}
}