
import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 K
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			// 정수 N 받기
			int N = Integer.parseInt(br.readLine());
			// 초기값 세팅
			int [][]result = new int[N+2][2];
			result[0][0]=1;
			result[0][1]=0;
			result[1][0]=0;
			result[1][1]=1;
			for(int j=2; j<N+1; j++) {
				result[j][0]= result[j-1][0]+result[j-2][0];
				result[j][1]= result[j-1][1]+result[j-2][1];
			}
			System.out.println(result[N][0] + " " + result[N][1]);
		}
	}
	
}
