
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 전체 용액의 수 N(2 이상 100,000 이하)
		int N = Integer.parseInt(br.readLine());
		
		// 용액의 특성값을 나타내는 N개의 정수
		int[] liq = new int[N];
		st= new StringTokenizer(br.readLine());
		br.close();
		for(int i=0; i<N; i++) {
			liq[i]=Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(liq);
		
		// 모두 산성
		if(liq[0]>0) System.out.println(liq[0]+" "+liq[1]);
		// 모두 알칼리성
		else if(liq[liq.length-1]<0) System.out.println(liq[liq.length-2]+ " "+liq[liq.length-1]);
		else {
			int start=0;
			int end = liq.length-1;
			int[] answer = {liq[start], liq[end]};
			int min = Integer.MAX_VALUE;
			// 두 종류이므로 넘어갈 수 없음
			while(start<end) {
				int temp=Math.abs(liq[start]+liq[end]);
				if(temp<min) {
					min=temp;
					answer[0]=liq[start];
					answer[1]=liq[end];
					if(temp==0) break;
				}
				if(liq[start]+liq[end]<0) {
					start++;
				}
				else{
					end--;
				}
			}
			System.out.println(answer[0]+ " "+ answer[1]);
		}
		
	}
}
