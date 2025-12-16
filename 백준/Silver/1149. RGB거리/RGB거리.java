
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 집의 수 N
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][] dp = new int[N][3];
    	
    	// RGB 비용 세팅
    	StringTokenizer st;
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int R = Integer.parseInt(st.nextToken());
    		int G = Integer.parseInt(st.nextToken());
    		int B = Integer.parseInt(st.nextToken());
    		
    		if(i == 0) {
    			dp[0][0]=R;
    			dp[0][1]=G;
    			dp[0][2]=B;
    		}else {
    			// 선택한 집의 색깔을 고를 경우 이전 집까지의 최소 배용에 더하기
    			dp[i][0]= R + Math.min(dp[i-1][1], dp[i-1][2]);
    			dp[i][1]= G + Math.min(dp[i-1][0], dp[i-1][2]);
    			dp[i][2]= B + Math.min(dp[i-1][0], dp[i-1][1]);
    		}
    	}
    	
    	// 마지막 집에서 RGB로 끝냈을 때의 최소값 비교
    	System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}