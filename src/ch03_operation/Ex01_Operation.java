package ch03_operation;

public class Ex01_Operation {

	public static void main(String[] args) {
		int i = 2, k = 3;
		double f = k / (double) i;
		System.out.printf("%d, %d, %d%n", k/i, i++, --k);	// 1, 2, 2
		System.out.printf("%.1f, %d, %d%n", f, i++, --k);		// 1.5, 3, 1
		
		char c = '안';
		System.out.println(c == '안');	// == 은 프리미티브 타입의 값 비교
		String s = new String("Hello");
		System.out.println(s == "Hello");	// 참조형에서는 저장위치가 같으냐를 물어보는 코드
		System.out.println(s.equals("Hello"));	// 참조형의 올바른 방법 equals: == ***
		
		System.out.println(i == k && k == 4); // i = 안 k = 1
		/* Short Circuit
		 * 논리식1 && 논리식2	논리식1이 false면
		 * 논리식1 && 논리식2	논리식1이 true면
		 */
		
		// 성적이 70점 이상이면 합격, 그렇지 않으면 불합격
		int score = 40 + (int) (61 * Math.random()); 	// 40 ~ 100
		char grade = score >= 70 ? '급' : '낙';
		System.out.printf("%d, %c%n" , score, grade);
	}

}
