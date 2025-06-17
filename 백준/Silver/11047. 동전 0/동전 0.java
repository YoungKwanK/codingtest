
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 동전 종류 N과 목표 합계 K
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 동전 종류 배열에 담기
		int[] coins = new int[N];
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// 동전의 개수 구하기
		int coinCount=0;
		int currentK=K;
		// 제일 큰 동전 단위 부터 나누기
		for(int i=coins.length-1; i>=0; i--) {
			coinCount+=currentK/coins[i];
			currentK%=coins[i];
		}
		System.out.println(coinCount);
	}	
	
}
