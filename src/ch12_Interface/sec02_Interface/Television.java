package ch12_Interface.sec02_Interface;

public class Television implements RemoteControllable { // 인터페이스 상속
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControllable.MAX_VOLUME)
			this.volume = RemoteControllable.MAX_VOLUME;
		else if (volume < RemoteControllable.MIN_VOLUME)
			this.volume = RemoteControllable.MIN_VOLUME;
		else
			this.volume = volume;
			
		System.out.println("현재 TV 볼륨: " + this.volume);
		
	}




}
