
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 받기
		int N = Integer.parseInt(br.readLine());
		
		// 걸리는 시간 받기
		int time[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		// 제일 적은 시간을 위해 오름차순 정렬
		Arrays.sort(time);
		// 사람마다 걸리는 시간을 저장할 sum 배열
		int sum[]=new int[N];
		int total=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum[i]+=time[j];
			}
			total+=sum[i];
		}
		System.out.println(total);
		
	}	
	
}
