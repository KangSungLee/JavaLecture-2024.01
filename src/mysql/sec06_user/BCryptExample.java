package mysql.sec06_user;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptExample {

	public static void main(String[] args) {
		String pwd = "1234qwerty";
		String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
		System.out.println(hashedPwd.length());
		System.out.println(hashedPwd);
		
		// 패스워드가 동일한지 확인
		boolean result = BCrypt.checkpw(pwd, hashedPwd);
		System.out.println(result);

	}

}

/* 
 * 암호화(Crypt)
 * 		평문	->		비문
 * 		plain text		Cipher text
 * 
 * 복원 가능	평문 복원  비문 복원이 가능하다
 * 				(공개키 알고리즘) ex) 전자사인
 * 				
 * 
 * 비복원	평문을 비문으로 가능하나 
 * 			비문을 평문으로 복원할수 없다
 * 			ex) 로그인할때
 */
