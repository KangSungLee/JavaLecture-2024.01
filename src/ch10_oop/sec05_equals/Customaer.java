package ch10_oop.sec05_equals;

import java.util.Objects;

public class Customaer {
		private int cid; 
		private String name;
		private int age;
		private boolean adult;
		
		public Customaer() { }
		public Customaer(int cid, String name, int age, boolean adult) {
			this.cid = cid;
			this.name = name;
			this.age = age;
			this.adult = adult;
		}
		
		
		public boolean equals(Object obj) {
			if (obj instanceof Customaer) {
				// cid 값만 같으면 동일한 객체
//				return this.cid == ((Customer) obj).getCid();
				// cid 값과 name이 같아야 동일한 객체
				return this.cid == ((Customaer) obj).getCid() 
						&& this.name.equals(((Customaer) obj).getName());
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.cid, this.age);
		}
		
		
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
		public boolean isAdult() {
			return adult;
		}
		public void setAdult(boolean adult) {
			this.adult = adult;
		}
		
}
