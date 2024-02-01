package Qq.q2;

import java.util.ArrayList;
import java.util.List;

public class MemberUtil {
	
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<Member>();
		Member james = new Member(101, "제임스", 1991, "010-2345-6789");
		Member maria = new Member(102, "마리아", 1995, "010-6789-2345");
		list.add(james);
		list.add(maria);
		return list;
	}
}