
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수의 개수 N 받기
		int N = Integer.parseInt(br.readLine());
		
		// 인덱스를 정수로 하는 배열 선언
		int[] nums = new int[20000001];
		Arrays.fill(nums,0);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int temp=Integer.parseInt(st.nextToken());
			if(temp<0) temp=temp*(-1)+10000000;
			nums[temp]++;
		}
		
		// M
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int temp=Integer.parseInt(st.nextToken());
			if(temp<0) temp=temp*(-1)+10000000;
			sb.append(nums[temp]).append(" ");
		}
		System.out.println(sb);
	}
	
}
