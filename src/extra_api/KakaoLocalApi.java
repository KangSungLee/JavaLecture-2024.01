package extra_api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpHeaders;
import java.util.Map;

/**
 * 도로명 주소로부터 위도(latitude), 경도(longitude) 정보를 구해주는 메소드
 */
public class KakaoLocalApi {
	
	public Map<String, Double> getGeocode(String addr) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("c:/temp/kakaoApiKey.txt"));
		String kakaoKey = br.readLine();
		br.close();
		String query = URLEncoder.encode(addr, "utf-8");
		String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json"
						+ "?query=" + query;
		
		URI uri = new URI(apiUrl);
		// 헤더 설정
//		HttpHeaders headers = new HttpHeaders();
		
		return null;
	}
}