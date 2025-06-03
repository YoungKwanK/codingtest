import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수의 갯수를 저장할 N
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// N개의 정수를 담을 deque
		Set<Integer> nums_N = new HashSet<>();
		
		// N개의 정수 받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums_N.add(Integer.parseInt(st.nextToken()));
		}
		
		// 정수의 갯수를 저장할 m
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		// M개의 정수 받기
		int []nums_M = new int[M];
		
		// M개의 정수 받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			nums_M[i]=Integer.parseInt(st.nextToken());
		}
		
		// 
		for(int i =0; i<M; i++) {
			int value = nums_N.contains(nums_M[i])? 1 : 0;
			System.out.println(value);
		}
	}
}
