package ch17_collection.part1_list.qna.q8_set;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));
		
		System.out.println(set.size());
		set.forEach(x -> System.out.println(x));
		System.out.println("----------------------------");
		for (Student s : set)
			System.out.println(s);

	}

}
