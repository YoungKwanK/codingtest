
import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 회의의 수 N(1 ≤ N ≤ 100,000)
		int N = Integer.parseInt(br.readLine());
		
		// 회의의 수만큼 시작 시간 종료 시간을 받음
		int[][] time = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
		}
		
		// 끝나는 시간을 기준으로 정렬, 같을 경우 시작 시간이 빠른 순으로 정렬
		Arrays.sort(time, (o1, o2) -> {
			if(o1[1]==o2[1]) {
				return o1[0]-o2[1];
			}
			else return o1[1] - o2[1];
		});
		
		
		// 최대값을 저장할 정답 변수
		int answer=1;
		int end = time[0][1];
		// 회의의 수만큼 반복
		for(int i=1; i<N; i++) {
			// 만약 이전 회의의 끝나는 시간보다 현재 회의의 시작시간이 같거나 큰 경우 바꿔줌
			if(end<=time[i][0]) {
				end=time[i][1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}
