/* 교통카드
 * 속성 : cash
 * 나이 : age
 * 
 * 7 <= age <= 12	730원
 * 13<= age <= 18	1010원
 * age >= 19			1450원
 * 
 * charge(int cash)	충전기능
 * 
 * getCash()		잔액확인
 * 
 * ride()			교통카드 잔액이 교통비보다 많거나 같으면 true
 * 					부족하면 false
 * 
 * toString()
 */
package ch06_class.sec04_tmoney;

public class Tmoney {
	private int cash;
	private int age;
	
	public static final int CHILD_FARE = 730;
	public static final int YOUTH_FARE = 1010;
	public static final int ADULT_FARE = 1450;
	
	public Tmoney() { }
	public Tmoney(int age, int cash) {
		this.age = age;
		this.cash = cash;
	}
	
	public int getCash() {
		return cash;
	}
	
	public void charge(int cash) {
		this.cash += cash;
	}
	
	public boolean ride() {
		if (age >= 7 && age <= 12) {
			if (cash >= CHILD_FARE) {
				cash -= CHILD_FARE; return true;
			}
			return false;
		} else if(age >= 13 && age <= 18) {
			if (cash >= YOUTH_FARE) {
				cash -= YOUTH_FARE; return true;
			}
			return false;
		} else if(age >= 19) {
			if (cash >= ADULT_FARE) {
				cash -= ADULT_FARE; return true;
			}
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "tmoney [cash=" + cash + ", age=" + age + "]";
	}
}
