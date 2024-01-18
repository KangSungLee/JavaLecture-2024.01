package ch06_class.sec02_customer;

public class CustomerMain {

	public static void main(String[] args) {
		Customer james = new Customer();
		james.setCid(1); james.setName("제임스"); james.setAge(27); james.setAdult(true);
		
		Customer maria = new Customer(2, "마리아", 23, true);
		
		Customer brian = new Customer(3, "브라이언", 17);
		
		System.out.println(james);System.out.println(maria);System.out.println(brian);
	}
}
/* Customer		
 * 	int cid				auto_increment
 * 	String name
 * 	int age
 * 	String email
 * 	LocalDate regDate	current_date
 * 
 * 회원가입시
 * String name
 * int age
 * String email
 * 
 * 업데이트시
 * int cid	
 * String name
 * int age
 * String email
 * 
 * 필요에 맞게
 */

/* Delivery
 * 	int did
 * 	int cid
 *  String addr
 *  String tel
 */


