import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 세로 N, 가로 M 크기의 집터, 인벤토리의 B개의 블럭
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		// N개의 줄에 각각 M개의 정수로 땅의 높이, 최대 높이 max
		int max=0;
		int[][] space = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				space[i][j]=Integer.parseInt(st.nextToken());
				if(space[i][j]>max) max=space[i][j];
			}
		}
		
		// 모든 경우의 수 구하기
		int answer = Integer.MAX_VALUE;
		int count;
		int h=max;
		int B_temp;
		
		for(int k=0; k<=max; k++) {
			count=0;
			B_temp=B;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// 원하는 높이보다 블록이 더 높게 쌓여있을 때
					if(k<space[i][j]) {
						count+=(space[i][j]-k)*2;
						B_temp+=space[i][j]-k;
					}
					// 원하는 높이보다 블록이 더 낮게 쌓여있을 때
					else if(k>space[i][j]){
						count+=((-1)*space[i][j]+k);
                        B_temp-=(k-space[i][j]);
					}
				}
			}
			if(B_temp>=0 && count<=answer) {
				answer=count;
				h=k;
			}
		}
		System.out.println(answer+" "+h);
	}
	
}
