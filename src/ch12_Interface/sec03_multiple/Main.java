package ch12_Interface.sec03_multiple;

import ch12_Interface.sec02_Interface.RemoteControllable;

public class Main {

	public static void main(String[] args) {
		RemoteControllable rc = new SmartTv();
		rc.turnOn(); rc.setVolume(5); rc.turnOff();
		
		Searchable sc = new SmartTv();
		sc.search("www.youtube.com");
		
		SmartTv stv = new SmartTv();
		stv.turnOn(); stv.setVolume(5); stv.search("naver"); stv.turnOff();
		
//		sc = new Searchable() { 필요없다~
//			public void search(String url) {
//				System.out.println("익명 구현체가" +url + " 검색을 합니다.");
//			}필요없다~
//			필요없다~
//		};필요없다~
//		sc.search("kakao");필요없다~
	}

}
