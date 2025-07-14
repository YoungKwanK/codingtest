import java.util.*;
import java.io.*;
public class Main{
	static int B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());
		
		// 결과를 저장할 StringBuilder()
		StringBuilder answer = new StringBuilder();
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			// A는 초기값 ( 0 이상 10,000 미만)
			int A = Integer.parseInt(st.nextToken());
			// B는 최종값
			B = Integer.parseInt(st.nextToken());
			
			// 테이블 정의
			Queue<Map<Integer, String>> q = new LinkedList<>(); 
			boolean[] visited = new boolean[10000];
			
			// 초기값 세팅
			Map<Integer, String> map;
			map= new HashMap<>();
			map.put(A,"");
			q.add(map);
			visited[A]=true;
			while(!q.isEmpty()) {
				Map<Integer, String> start = q.poll();
				int num=0;
				for(int i : start.keySet()) {
					num=i;
				}
				if(num==B) {
					answer.append(start.get(num)).append("\n");
					break;
				}
				// D를 할 경우
				int dStart=num*2;
				if(dStart>9999) {
					dStart%=10000;
				}
				if(!visited[dStart]) {
					visited[dStart]=true;
					map= new HashMap<>();
					map.put(dStart,start.get(num)+"D");
					q.add(map);
				}
				
				// S를 할 경우
				int sStart=num-1;
				if(num==0) {
					sStart=9999;
				}
				if(!visited[sStart]) {
					visited[sStart]=true;
					map= new HashMap<>();
					map.put(sStart,start.get(num)+"S");
					q.add(map);
				}
				
				// L을 할 경우
				int lStart=(num%1000)*10+(num/1000);
				if(!visited[lStart]) {
					visited[lStart]=true;
					map= new HashMap<>();
					map.put(lStart,start.get(num)+"L");
					q.add(map);
				}
				
				// R을 할 경우
				int rStart=(num%10)*1000+(num/10);
				if(!visited[rStart]) {
					visited[rStart]=true;
					map= new HashMap<>();
					map.put(rStart,start.get(num)+"R");
					q.add(map);
				}
			}
		}
		System.out.println(answer);
	}
}
