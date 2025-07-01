
import java.util.*;
import java.io.*;
public class Main{
	static int[][] board=new int[5][5];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	// 답을 저장할 hashset(중복제거)
	static Set<String> answer = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 체스판 초기화
		for(int i=0; i<5; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int count;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				count=0;
				dfs(i, j, count, new String());
			}
		}
		// 정답 출력
		System.out.println(answer.size());
		answer.add(new String());
		
	}
	//dfs
	static void dfs(int x, int y, int count, String s) {
		// 다섯번 동작 시 answer에 추가하고 종료
		if(count==6) {
			answer.add(s);
			return;
		}
		count++;
		s+=(board[x][y]);
		for(int i=0; i<4; i++) {
			if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<5 && y+dy[i]<5) {
				dfs(x+dx[i], y+dy[i], count, s);
			}
		}
	}
}
