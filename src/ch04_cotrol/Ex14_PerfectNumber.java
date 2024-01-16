package ch04_cotrol;

import java.util.Scanner;
import java.util.function.Function;

public class Ex14_PerfectNumber {

	public static void main(String[] args) {
		// 100000 이하의 완전수
		for (int i = 2 ; i <= 10000; i++){
//			int sum = 0;
//		    for(int k = 1; k < i; k++){
//		        if (i % k == 0)
//		            sum += k;
//		    }
			int divSum = divisorSum(i);
		    if (i == divSum)
		    	System.out.print (i + " ");
		}
		
		

	}
	static int divisorSum(int num) {
		int divSum = 0;
		for (int i = 1; i<num; i++)
			if (num % i == 0)
				divSum +=i;
		return divSum;
	}
}
