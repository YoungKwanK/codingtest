
import java.util.*;
import java.io.*;
public class Main{
	static StringBuilder sb = new StringBuilder();
	static List<Integer> nums = new ArrayList<>();
	static int N;
	static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N과 M 받기
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 재귀함수 실행
		rec(1);
		System.out.println(sb);
	}
	
	public static void rec(int num) {
		if(nums.size()==M) {
			for(int i=0; i<M; i++) {
				sb.append(nums.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=num; i<=N; i++) {
			nums.add(i);
			rec(i+1);
			nums.remove(nums.size()-1);
		}
	}
}