
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 삼각형의 크기 n 받기 
    	st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	
    	// 삼각형의 크기만큼 이차원 배열 초기화
    	int[][] ta = new int[n][n];
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<=i; j++){
    			ta[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 밑에서부터 값 비교하여 더하면서 올리기
    	for(int i=n-1; i>0; i--) {
    		for(int j=0; j<i; j++) {
    			ta[i-1][j] += Math.max(ta[i][j], ta[i][j+1]);
    		}
    	}
    	System.out.println(ta[0][0]);
    }
}