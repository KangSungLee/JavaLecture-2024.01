package extra_crawling.sec03_Melon;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
	/*
	 * 크롤링 7단계
	 * 		1. 사이트에 접속하고 HTML 데이터를 가져와 파싱
	 * 		2. 원하는 데이터 찾기(<li>, <tr>, ...)
	 * 		3. 하나를 선택해서 원하는 정보 추출 (연습게임)
	 * 		4. 반복문을 사용하여 페이지 내에 이는 데이터 가져오기
	 * 		5. 오류가 발생하면 오류를 해결하고 2,3,4 과정을 반복
	 * 		6. 모든 페이지에 대해 반복하기
	 * 		7. CSV(Comma Separated Values) 파일로 만들기
	 */
	public static void main(String[] args) throws IOException {
		String url = "https://www.melon.com/chart/index.htm";	// 1
		Document doc = Jsoup.connect(url).get();				// 1
		Elements trs = doc.select(".service_list_song.type02.d_song_list > table > tbody > tr");// 2

		String date = doc.selectFirst(".year").text().strip();
		String time = doc.selectFirst(".hour").text().strip();
		System.out.println(date + " " + time + " 차트 순위");
		System.out.println("========================================================");
		MelonChatService melonChatService = new MelonChatService();
		List<MelonChat> list = melonChatService.getBestCart(trs);
		list.forEach(x -> System.out.println(x));

	}

}
