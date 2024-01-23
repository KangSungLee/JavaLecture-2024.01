package q1;

import java.util.Scanner;

public class 알람시계 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("몇시>");
		int hour = Integer.parseInt(scan.nextLine());
		System.out.print("몇분>");
		int minute = Integer.parseInt(scan.nextLine());
		System.out.print("몇분 일찍 맞춰드릴까요>");
		int brMinute = Integer.parseInt(scan.nextLine());
		scan.close();

		int newHour = 0, newMinute = 0;
		if (minute >= brMinute) {
		    newHour = hour;
		    newMinute = minute - brMinute;
		} else {
		    if (hour == 0){
		        newHour = 23;
		        newMinute = minute + 60 - brMinute ;
		    } else {
		        newHour = hour - 1;
		        newMinute = minute + 60 - brMinute ;
		    }
		}
		
		System.out.println(hour + "시" + minute +"분 --> " + newHour + "시" + newMinute + "분");
				
		
	}

}
