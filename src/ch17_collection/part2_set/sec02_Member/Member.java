package ch17_collection.part2_set.sec02_Member;

import java.util.Objects;

public class Member {
	private int age;
	private String name;
	
	public Member() { }
 	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
 	
 	
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {	// instanceof 내 타입인지 확인
			Member m = (Member) obj;	// obj를 강제 타입변환시 (Member)를 사용하여 Member로 변환
			return m.getAge() == this.age && m.getName().equals(this.name);
		} else
			return false;
	}
	//---------------------------------------
	
	@Override
	public String toString() {
		return "Member [age=" + age + ", name=" + name + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
