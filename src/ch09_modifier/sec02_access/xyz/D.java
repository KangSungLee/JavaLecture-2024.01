package ch09_modifier.sec02_access.xyz;

import ch09_modifier.sec02_access.abc.A;

public class D extends A { // extends A D가 A에 상속을 받는다
	void xyz() {
		System.out.println(a + b); 		// 다른 패키지 A 클래스의 a, b 변수 사용가능
	}
}
