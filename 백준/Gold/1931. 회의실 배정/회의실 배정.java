
import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회의의 수 N
        int N = Integer.parseInt(br.readLine());
        
        // 시간 받기
        int[][] time = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, (o1, o2)->{
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}else return o1[1]-o2[1];
		});
		
		int answer=1;
		int end = time[0][1];
		for(int i=1; i<N; i++) {
			if(end<=time[i][0]) {
				end=time[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
    }
}