package extra_crawling.sec03_Melon;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) throws IOException {
		String url = "https://www.melon.com/chart/index.htm";
		Document doc = Jsoup.connect(url).get();
		String date = doc.selectFirst(".year").text().strip();
		String time = doc.selectFirst(".hour").text().strip();
		System.out.println(date + " " + time + " 차트 순위");
		System.out.println("========================================================");
		MelonChatService melonChatService = new MelonChatService();
		List<MelonChat> list = melonChatService.getBestCart();
		list.forEach(x -> System.out.println(x));

	}

}
