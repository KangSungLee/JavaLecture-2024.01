package ch12_Interface.sec01_abstract;

public class Main {

	public static void main(String[] args) {
		// 추상 클래스는 객체 생성안됨
//		Animal animal = new Animal();
		
		cat cat = new cat();
		cat.cry();
		
		Dog dog = new Dog();
		dog.cry();
		
		Animal animal = new cat();
		animal.cry();

	}

}
