
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 의견의 수 n 받기
		int n = Integer.parseInt(br.readLine());
		if(n==0) {
			System.out.println(0);
		}
		else {
			
			// 카운팅 배열, 정수 배열의 기본값은 0
			int[] nums = new int[31];
			// 카운팅 하기
			for(int i=0; i<n; i++) {
				nums[Integer.parseInt(br.readLine())]++;
			}
			// 제외할 인원 수 구하기
			int outNum = (int)Math.round(n*15.0/100);
			
			int first=0;
			first=outNum;
			int last=0;
			last=outNum;
			// 제외 시키기
			for(int i=1; i<31; i++) {
				while(first!=0 && nums[i]>0) {
					nums[i]--;
					first--;
				}
			}
			for(int i=1; i<31; i++) {
				while(last!=0 && nums[31-i]>0) {
					nums[31-i]--;
					last--;
				}
			}
			
			// 평균 구하기
			int sum =0;
			for(int i=1; i<31; i++) {
				sum+=nums[i]*i;
			}
			System.out.println(Math.round((double)sum/(n-outNum*2)));
			
		}
	}
	
}
