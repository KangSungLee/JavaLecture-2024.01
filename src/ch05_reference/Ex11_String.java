package ch05_reference;

public class Ex11_String {

	public static void main(String[] args) {
		// 생성방법
		String str1 = new String("문자열");
		String str2 = "문자열";
		
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97}; // Hello Java 를 비트화
		String str3 = new String(bytes);
		System.out.printf("%s, %s, %s%n", str1, str2, str3);
		// String 객체내의 값을 변경 불가 (새로운 객체를 생성해서 변경한다)
		
		String str4 = "문자열";
		System.out.println(str2 == str4); // str2와 str4가 가리키는 곳이 동일함
		// 실수가 문자열에 붙으면 문자열이된다
		
		Person james = new Person("제임스", 29, "프로그래머");
		Person maria = new Person("마리아", 23, "학생");
		System.out.println(james + " - 123");//person class의 toString() method 적용
		System.out.println(maria + " - 456");
	}

}
