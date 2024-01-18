package ch05_reference;

public class Q02_DigitalClock {

	public static void main(String[] args) {
		int duration = 0;
		for (int hour = 0; hour <= 23; hour++) {
			for(int minute = 0; minute <=59; minute++) {
				String timStr = hour + ":" + minute;
				if (timStr.indexOf("3") >= 0)
					// timStr안에 3이라는 문자가 있으면
					duration += 60;	// duration에 +60을 해줘라
			}
		}
			System.out.println(duration);

	}

}
