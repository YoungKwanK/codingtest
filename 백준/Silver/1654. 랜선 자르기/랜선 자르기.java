import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
//		K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 랜선받기
		long max=0;
		int[] l = new int[K];
		for(int i=0; i<K; i++) {
			l[i]=Integer.parseInt(br.readLine());
			if(l[i]>max) max=l[i];
		}
		
		long min=1;
		long mid=1;
		long answer=0;
		while(min<=max) {
			mid = (min+max)/2;
			long count=0;
			
			for(int i=0; i<K; i++) {
				count+=l[i]/mid;
			}
			
			if(count>=N) {
				answer=mid;
                min=mid+1;
			}else{
				max=mid-1;
				
			}
		}
		System.out.println(answer);
	}
}

