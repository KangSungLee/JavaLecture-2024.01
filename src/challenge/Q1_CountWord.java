package challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q1_CountWord {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 파일> ");
		String filename = scan.nextLine();
		scan.close();
		BufferedReader br = new BufferedReader(new FileReader(filename));

		Set<String> wordSet = new HashSet<String>();		// 고유 단어
		List<String> wordList = new ArrayList<String>();	// 단어(중복가능)
		String line = null;
		int count = 0;				// 문자 갯수
		while((line = br.readLine()) != null) {
			count += line.length();
			String cleanText = line.replaceAll("[^0-9A-Za-zㄱ-ㅎㅏ-ㅣ가-힣]", " ");
			String[] cleanWords = cleanText.split("\\s+");	// 임의의 연속된 공백으로 단어 분리
			for (String word: cleanWords) {
				if (word.equals(""))
					continue;
				wordSet.add(word.toLowerCase());
				wordList.add(word);
			}
		}
		br.close();
		System.out.println(wordSet.size() + ", " + wordList.size() + ", " + count);
		System.out.println(wordSet);
	}

}