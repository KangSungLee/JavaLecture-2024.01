package Qq;

public class q1 {

	public static void main(String[] args) {
		// 1. 1에서 100까지 3의 배수의 합을 구하세요
		int threeSum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				threeSum += i;
			}
		}
		System.out.println("1에서 100까지의 3의 배수의 합: " + threeSum);

		// 2. 1에서 20까지 홀수 제곱의 합을 구하세요
		int oddNum = 0;
		for (int i = 1; i <= 20; i += 2) {
			oddNum += i * i;
		}
		System.out.println("1에서 20까지 홀수의 제곱의 합: " + oddNum);

		// 3. 어떤 수가 소수(prime number: 1과 자기자신만을 약수로 갖는 수, 예: 2, 3, 5 …)인가를
		// 판단하는 메소드 Boolean isPrime(int num); 를 만드세요

		int number = 5;
		boolean result = isPrime(number);
		if (result) {
			System.out.println(number + "소수입니다.");
		} else {
			System.out.println(number + "소수가 아닙니다.");
		}

		// 4. 3)에서 만든 메소드를 이용하여 2에서부터 100까지 소수의 합을 구하세요

		int resultSum = 0;
		for (int i = 2; i <= 100; i++) {
			result = isPrime(i);
			if (result) {
				resultSum += i;
			}
		}
		System.out.println("2에서부터 100까지 소수의 합" + resultSum);

	}

	// 3번
	static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}

		for (int i = 2; i <= number - 1; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}