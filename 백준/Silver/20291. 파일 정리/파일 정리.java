

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 파일의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 파일의 확장자명과 나온 횟수를 저장할 TreeMap 선언
		Map<String, Integer> tm = new TreeMap<>();
		
		// 파일의 개수만큼 파일 받기
		for(int i=0; i<N; i++) {
			// 파일을 받으면서 파일명 분리
			String[] temp = br.readLine().split("\\.");
			// 트리맵에 추가
			tm.put(temp[1], tm.getOrDefault(temp[1], 0)+1);
		}
		// 출력
		for(String s : tm.keySet()) {
			System.out.println(s+" "+tm.get(s));
		}
	}
}
