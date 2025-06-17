
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 포켓몬 도감 수 N과 조회할 포켓몬 수 M을 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 포켓몬 도감 채울 map선언
		Map<String, String> poketmon = new TreeMap<>();
		
		// 포켓몬 도감에 저장하기 : 양방향 저장
		for(int i=1; i<=N; i++) {
			String temp=br.readLine();
			poketmon.put(String.valueOf(i), temp);
			poketmon.put(temp, String.valueOf(i));
		}
		
		// 시간 초과를 대비한 StringBuilder 사용
		StringBuilder sb = new StringBuilder();
		
		// 포켓몬 찾기
		for(int i=0; i<M; i++) {
			String temp = br.readLine();
			sb.append(poketmon.get(temp)).append("\n");
		}
		System.out.println(sb);
	}
	
}