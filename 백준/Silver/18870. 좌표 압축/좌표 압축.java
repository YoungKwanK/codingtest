
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 좌표의 개수 N
		int N=Integer.parseInt(br.readLine());
		// N개의 좌표의 개수
		int[] x = new int[N];
		Set<Integer> temp = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num=Integer.parseInt(st.nextToken());
			temp.add(num);
			x[i]=num;
		}
		// 값을 저장할 StringBuilder
		StringBuilder sb =new StringBuilder();
		
		// 로직 수행
		int count=0;
		// map에 옮겨담기
		Map<Integer, Integer> myMap = new HashMap<>();
		for(int n : temp) {
			myMap.put(n,count++);
		}
		// 값 찾기
		for(int i=0; i<x.length; i++) {
			sb.append(myMap.get(x[i])).append(" ");
			
		}
		// 정답 출력
		System.out.println(sb);
	}
	
}
