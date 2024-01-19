package ch09_modifier.sec03_static;

public class SampleMain {

	public static void main(String[] args) {
		// 인스턴스 필드, 메소드를 사용하는 방법 ** 일반적으로 사용
		Sample sample = new Sample();
		
		System.out.println(sample.instanceField);
		sample.instanceMethod();
		
		// 스태틱 필드, 메소드를 사용하는 방법 ** 상속값만 스태틱으로 사용
		System.out.println(sample.STATIC_FIELD);
		sample.staticMethod();
	}

}
