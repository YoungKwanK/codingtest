
import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 영어 지문에 나오는 단어의 개수 N, 외울 단어의 길이 기준이 되는 M
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 단어를 입력받을 자료구조 설정
		Map<String, Integer> words = new HashMap<>();
		
		// 단어 입력 받기
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			// 단어 길이가 M보다 작을 시 for문 넘기기
			if(temp.length()<M) continue;
			// 이미 해당 단어가 나왔을 땐 빈도수 올리고 없을 경우 1
			words.put(temp, words.getOrDefault(temp, 0)+1);
		}
		
		// 이름값 가져와서 리스트에 저장
		List<String> wordsKey = new ArrayList<>(words.keySet());
		
		// 정렬
		wordsKey.sort((a1, a2)->{
			// 자주 나오는 단어일수록 앞에 배치
			if(words.get(a1)!=words.get(a2)) {
				return words.get(a2)-words.get(a1);
			}
			// 단어의 길이가 길수록 앞에 배치
			if(a1.length()!=a2.length()) {
				return a2.length()-a1.length();
			}
			// 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
			return a1.compareTo(a2);
		});
		for(String word : wordsKey) {
			sb.append(word).append("\n");
		}
		System.out.print(sb);
	}
}