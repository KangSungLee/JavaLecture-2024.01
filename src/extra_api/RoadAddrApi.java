package extra_api;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class RoadAddrApi {

	public String getRoadAddr (String keyword) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("c:/temp/roadApiKey.txt"));
		String confmKey = br.readLine();
		br.close();
		int currentPage = 1, countPerPage = 5;
		String resultType = "json";
		keyword = URLEncoder.encode(keyword, "utf-8");	// 한글입력되게
		String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do"
						+ "?confmKey=" + confmKey			// 시작은 ?
						+ "&currentPage=" + currentPage		// 중간은 &
						+ "&countPerPage=" + countPerPage
						+ "&resultType=" + resultType
						+ "&keyword=" + keyword;
		
		URL url = new URL(apiUrl);
		br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
    	StringBuffer sb = new StringBuffer();
    	String tempStr = null;
		
    	while(true){
    		tempStr = br.readLine();
    		if(tempStr == null) 
    			break;
    		sb.append(tempStr);								// 응답결과 JSON 저장
    	}
    	br.close();
    	
		return sb.toString();
	}
	
}
