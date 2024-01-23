package ch14_exception;

public class Ex04_Finally {

	public static void main(String[] args) {
		String str = null;
		try {
			str = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("사용법: 매개변수를 입력하세요");
		}
		System.out.println(str);
		
		int value = 0;
		try {
			value = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace(); 	// 로그에 보이는 에러삭제
			System.out.println("사용법: 숫자만 입력하세요");
		}
		System.out.println(value);
	}

}
