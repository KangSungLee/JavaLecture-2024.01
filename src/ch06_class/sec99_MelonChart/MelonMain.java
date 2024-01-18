package ch06_class.sec99_MelonChart;

public class MelonMain {

	public static void main(String[] args) {
		Melon[] melons = new Melon[5];
		melons[0] = new Melon(1, "비의 랩소디", "임재현", "비의 랩소디", 33193);
		melons[1] = new Melon(2, "To. X", "태현", "To. X", 82784);
		melons[2] = new Melon(3, "Perfect Night", "르세라핌", "Perfect Night", 94989);
		melons[3] = new Melon(4, "Drama", "에스파", "Drama", 68534);
		melons[4] = new Melon(5, "에피소드", "이무진", "에피소드", 33230);
		
		for(Melon Mel: melons)
		System.out.println(Mel);
	}
}
