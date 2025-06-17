
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 듣도못한 사람 N, 보도 못한 사람 수 M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 듣도못한 사람과 보도 못한 사람 수 저장할 set 선언
		Set <String> p1 = new TreeSet<>();
		Set <String> p2 = new TreeSet<>();
		
		// 듣도못한 사람 받기
		for(int i=0; i<N; i++) {
			p1.add(br.readLine());
		}
		// 보도못한 사람 받기
		for(int i=0; i<M; i++) {
			p2.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		int count=0;
		
		for(String s : p1) {
			if(p2.contains(s)) {
				count++;
				sb.append(s).append("\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
	
}