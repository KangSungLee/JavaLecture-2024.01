package ch06_class.sec98_Interpark;

public class InterparkMain {

	public static void main(String[] args) {
		Interpark[] ranks = new Interpark[5];
		ranks[0] = new Interpark(1, "처음부터 시작하는 주식투자 단타전략", "홍인기", "", "길벗", 18900);
		ranks[1] = new Interpark(2, "마흔에 읽는 쇼펜하우어", "강용수", "", "유노북스", 15300);
		ranks[2] = new Interpark(3, "세이노의 가르침", "세이노", "", "데이원", 6480);
		ranks[3] = new Interpark(4, "이처럼 사소한 것들", "Claire Keegan", "홍한별", "다산책방", 12420);
		ranks[4] = new Interpark(5, "내가 생각한 인생이 아니야", "류시화", "", "수오서재", 16200);
		
		for(Interpark rank :ranks)
			System.out.println(rank);
		

	}

}
