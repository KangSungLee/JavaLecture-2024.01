package ch04_cotrol;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex03_FullAge {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
//		System.out.println(today);		// 2024-01-16
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
//		System.out.printf("%d, %d, %d%n", year, month, day); // 2024, 1, 16
		
		Scanner scan = new Scanner(System.in);
		System.out.print("생년>");
		int bYear = Integer.parseInt(scan.nextLine());
		System.out.print("생월>");
		int bMonth = Integer.parseInt(scan.nextLine());
		System.out.print("생일>");
		int bDay = Integer.parseInt(scan.nextLine());
		
		int age;
		 if (month > bMonth) 
			 age = year - bYear;
		 else if (month < bMonth) 
		     age = year - bYear - 1;
		 else {
			 if (day >= bDay)
				 age = year - bYear;
			 else
				 age = year - bYear - 1;
		 }
		System.out.println("만나이: " + age);
				 
		// Refactoring
		int fullAge = year - bYear;
		if (month < bMonth || (month == bMonth && day < bDay))
			fullAge--;
		System.out.println("만나이: " + fullAge);
		
		// 한줄
		int age3 = (month < bMonth || (month == bMonth && day < bDay)) ? 
				year - bYear - 1 : year - bYear;
		System.out.println("만나이: " + age3);
		}
	
	}


