
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 동전의 개수 n과 원하는 가치의 합 k
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 동전의 가치 저장
		int []coins = new int[n];
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// 정답을 저장할 변수 초기화
		int answer = -1;
		
		// dp 테이블 세팅
		int[] dp = new int[k+1];
		// 초기값 세팅 - 최솟값을 구하므로 최대값들을 저장
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1; i<k+1; i++) {
			for(int j=0; j<n; j++) {
				if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE)
					dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
			}
		}
		if(dp[k]==Integer.MAX_VALUE) System.out.println(answer);
		else System.out.println(dp[k]);
		
	}
}
