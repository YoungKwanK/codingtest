
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 지방의 수를 의미하는 정수 N(3 이상 10,000 이하)
		int N = Integer.parseInt(br.readLine());
		
		// 각 지방의 예산요청을 표현하는 N개의 정수
		int max=0;
		int[] moneys = new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			moneys[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, moneys[i]);
		}
		
		// 총 예산을 나타내는 정수 M(1 이상 100,000 이하)
		int M = Integer.parseInt(br.readLine());
		
		// 초기값 세팅
		int answer=-1;
		int start = M/moneys.length;
		int end = max;
		int sum;
		while(start<=end) {
			sum=0;
			int mid = (start+end)/2;
			for(int money : moneys) {
				if(money<mid)sum+=money;
				else sum+=mid;
			}
			if(sum==M) {
				answer = mid;
				break;
			}
			else if(sum>M) {
				end=mid-1;
			}
			else {
				start=mid+1;
				answer = mid;
			}
		}
		System.out.println(answer);
	}
}
