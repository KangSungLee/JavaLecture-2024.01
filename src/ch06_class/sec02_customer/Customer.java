package ch06_class.sec02_customer;

import java.time.LocalDate;

// 클래스명
public class Customer {
	// 필드를 만들고 생성자랑 메소드 기터셋터를 source에서 클릭해서 생성하면된다
	private int cid; // 고유값을 하나
	private String name;
	private int age;
	private boolean adult;
	

	// 생성자 (Constructor)
	public Customer() { }
	
	public Customer(int cid, String name, int age) {
//		this.cid = cid;
//		this.name = name;
//		this.age = age;
//		this.adult = age > 19 ? true : false;
		this(cid, name, age, age > 19 ? true : false);
	}

	public Customer(int cid, String name, int age, boolean adult) {
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.adult = adult;
	}
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", adult=" + adult + "]";
	}
	
	// Getter/Setter method
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isAdult() {	// boolean 는 is로 시작한다
		return adult;
	}
	
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
}