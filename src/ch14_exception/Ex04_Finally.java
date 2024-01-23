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
		} finally {	// finally 무조건 출력이 발생하는 경우
			System.out.println("예외와 상관없이 무조건 실행됩니다.");
		}
		System.out.println(value);
	}

}
