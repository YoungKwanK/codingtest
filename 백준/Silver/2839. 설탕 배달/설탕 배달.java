
import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 설탕의 무게에 따라 저장
		int []sugarKg = {3, 5};
		// N 입력
		int N = Integer.parseInt(br.readLine());
		int[] sugar=new int[N+1];
		
		Arrays.fill(sugar, Integer.MAX_VALUE);
		
		sugar[0]=0;
		
		for(int i=3; i<=N; i++) {
			for(int kg : sugarKg) {
				if(i-kg>=0 && sugar[i-kg]!=Integer.MAX_VALUE) {
					sugar[i]=Math.min(sugar[i], sugar[i-kg]+1);
				}
			}
		}
		if(sugar[N] == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(sugar[N]);
	}
}
