package Qq.q2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list = getMemberList();
		list.get(0).setTel("010-1111-2222");
		list.get(1).setTel("010-4444-5555");
		list.forEach(x -> System.out.println(x));

	}

	public static List<Member> getMemberList() {
		List<Member> members = new ArrayList<Member>();
		members.add(new Member(1, "james",1998,"010-1234-5678"));
		members.add(new Member(2, "maria",1999,"010-9123-4567"));
		return members;
		}
}

