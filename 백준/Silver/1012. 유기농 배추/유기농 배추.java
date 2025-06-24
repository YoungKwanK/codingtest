
import java.util.*;
import java.io.*;
public class Main{

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;
	static int[][] table;
	
	
	// dfs 연산
	static void dfs(int x, int y) {
		// 방문했으므로 true로 바꿔줌
		visit[x][y]=true;
		// 위, 아래, 오른쪽, 왼쪽 체크
		for(int i=0; i<4; i++) {
			int moveX = x+dx[i];
			int moveY = y+dy[i];
			if(moveX<0 || moveX>=table.length || moveY <0 || moveY>=table[0].length ) continue;
			if(visit[moveX][moveY] || table[moveX][moveY]!=1) continue;
			dfs(moveX,moveY);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스의 갯수 T
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		// 테스트 케이스만큼 반복
		while(T-->0) {
			// 가로길이 M, 세로 길이 N, 배추가 심어져있는 위치 개수 K
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// 테이블 초기화
			table = new int[M][N];
			// 방문을 확인할 visit 배열 초기화
			visit = new boolean[M][N];
			
			// 배추가 심어져있는 위치에 1 넣기, table 값 넣기
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				table[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
			}
			
			// 정답 변수
			int answer=0;
			
			// 모든 자리 탐색
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					// 방문한 곳이 아니고 배추가 있을 경우 탐색
					if(!visit[i][j] && table[i][j]==1) {
						dfs(i, j);
						//하나의 경우의 수 임으로
						answer++;
					}
				}
			}
			
			System.out.println(answer);
			
		}

	}
	
}
