package extra_crawling.sec03_Melon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MelonChatService {

	public List<MelonChat> getBestCart(Elements trs) throws IOException {
		List<MelonChat> list = new ArrayList<MelonChat>();
		
		for (int i = 0; i < trs.size(); i++) {					// 4
			Element tr = trs.get(i);
			String rank_ = tr.selectFirst(".rank").text().strip();
			int rank = Integer.parseInt(rank_);
			String title = tr.selectFirst(".ellipsis.rank01 > span > a").text().strip();
			String artist = tr.selectFirst(".ellipsis.rank02 > a").text().strip();
			String album = tr.selectFirst(".ellipsis.rank03 > a").text().strip();
			String src = tr.selectFirst("td:nth-child(4) > div > a > img").attr("src");
			MelonChat mc = new MelonChat(rank, title, artist, album, src);
			list.add(mc);
		}
		return list;
		// 에러 확인
//		for (int i = 0; i <trs.size(); i++) {
//			try {
//				Element tr = trs.get(i);
//				// 작업진행
//			} catch (Exception e) {
//				System.out.println(i);	// 에러 발생한 위치를 확인해서 에러 수정
//			} 
//		}
	}
}
