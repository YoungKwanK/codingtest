import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// M개의 정수
		int M = Integer.parseInt(br.readLine());
		
		// 정수 받기
		Set<Integer> sM = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			sM.add(Integer.parseInt(st.nextToken()));
		}
		
		// N개의 정수
		int N = Integer.parseInt(br.readLine());
		
		// 정수를 하나씩 받으며 있는 지 확인
		int[] arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i]=Integer.parseInt(st.nextToken());
		}
		for(int num : arrN) {
			if(sM.contains(num)) System.out.println(1);
			else System.out.println(0);
		}
	}
}
