package ch10_oop.sec04_polymorphism;

public class Dog extends Animal{
	//@Override생략가능
	void sound() {
		System.out.println("멍멍!!");
	}
	
	void walk() { 
		System.out.println("왈왈산책");
	}
}
