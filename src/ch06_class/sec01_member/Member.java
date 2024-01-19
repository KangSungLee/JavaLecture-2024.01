// 지금까지는 절차 지향형 (절차대로 반응한다.)
// 클래스부터는 객체(오브젝트) 지향형 (액션시 반응한다?)
// 상속을 받을수있다. 객체를 찍어내는 붕어빵틀?
package ch06_class.sec01_member;	// 패키지 이름이 같으면 액세스가 허용이된다
									// public 외부공개 private 외부공개 X
import java.time.LocalDate;

public class Member {	// public 접근제한자
	// 필드,속성, 멤버
	public String name;	
	private LocalDate birthday;	
	private String email;	
	
	// 생성자(Constructor)
	public Member() { }	
	
	public Member(String name, LocalDate birthday, String email) {
		this.name = name;	//this. 붙이면 필드에 name을 가르킴
		this.birthday = birthday;
		this.email = email;
	}
	// 메소드(Method)
	public int getAge() {
        LocalDate today =  LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        int age = (month < birthday.getMonthValue() || (month ==  birthday.getMonthValue() && day <birthday.getDayOfMonth())) ? 
               year - birthday.getYear() -1 : year - birthday.getYear();
        return age;
     }


	
	@Override
    public String toString() {
       return "Member [name=" + name + ", birthday=" + birthday + ", email=" + email + 
    		   ", age=" +getAge() + "]";
    }
    
    public LocalDate getBirthday() {
       return birthday;
    }


    public void setBirthday(LocalDate birthday) {
       this.birthday = birthday;
    }


    public String getEmail() {
       return email;
    }


    public void setEmail(String email) {
       this.email = email;
    }

	// 내부클래스 안쓰는것
	class InnerClass {
		
	}
	
}
	// 외부 클래스 안쓰는것
class ExternalClass {	// 디폴트
	
}
