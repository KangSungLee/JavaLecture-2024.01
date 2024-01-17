package ch05_reference;

import java.util.Scanner;

public class Ex12_StringMethod {

	public static void main(String[] args) {
		String str1 = "Hello Java";
		String str2 = "안녕하세요? 반값습니다.";
		
		// 스트링의 길이 - 속성이 아니라 메소드임
		System.out.println(str1.length() + ", " + str2.length());
		
		// 문자열 검색
		System.out.println(str2.charAt(0) + ", " + str2.charAt(7)); 	// 안, 반
		
		// 주민등록번호를 보고받아서 남자 여자 구별
		Scanner scan = new Scanner(System.in);
		System.out.print("입력> ");
		String gender1 = scan.nextLine();
		
//		String ssn = "010624-3123456";
		char gender2 = gender1.charAt(7);
		switch(gender2) {
		case '1':
		case '3':
			System.out.println("남자"); break;
		case '2':
		case '4':
			System.out.println("여자"); break;
		}
	}
	
}
