
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        // 적어도 늘려야하는 관광객 수 C와 형택이가 홍보할 수 있는 도시의 개수 N
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] promotion = new int[N][2];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	// 비용과 얻을 수 있는 고객 수
        	int money = Integer.parseInt(st.nextToken());
        	promotion[i][0]=money;
        	int customer = Integer.parseInt(st.nextToken());
        	promotion[i][1]=customer;

        }
        // dp 테이블 정의 - dp의 인덱스는 비용
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=1; i<=dp.length; i++) {
        	for(int j=0; j<N; j++) {
        		if(i-promotion[j][0]>=0 && dp[i-promotion[j][0]]!=Integer.MIN_VALUE) {
        			dp[i] = Math.max(dp[i], dp[i-promotion[j][0]]+promotion[j][1]);
        		}
        	}
        	if(dp[i]>=C) {
    			System.out.println(i);
    			return;
    		}
        }
        
    }
}