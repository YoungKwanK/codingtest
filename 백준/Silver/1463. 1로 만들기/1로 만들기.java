
import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 N
		int N = Integer.parseInt(br.readLine());
		
		// dp
		int[] result = new int[N+1];
		Arrays.fill(result,Integer.MAX_VALUE);
		result[1]=0;
		for(int i=2; i<N+1; i++) {
			if(i%3==0) {
				result[i]=Math.min(result[i],result[i/3]+1);
			}
			if(i%2==0) {
				result[i]=Math.min(result[i],result[i/2]+1);
			}
			result[i]=Math.min(result[i],result[i-1]+1);
		}
		System.out.println(result[N]);
	}
	
}
