
import java.util.*;
import java.io.*;
public class Main{
	
	// 친구 관계 맵을 담을 그릇
	static List<Integer>[] frineds;
	static boolean[] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 두 정수 N, M(2 ≤ N, M ≤ 100)
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 테이블 초기화
		int[][] map = new int[N+1][M+1];
		// 테이블 값 넣기
		for(int i=1; i<N+1; i++) {
			String[] temp = br.readLine().split("");
			for(int j=1; j<M+1; j++) {
				map[i][j]=Integer.parseInt(temp[j-1]);
			}
		}
		int answer =0;
		// bfs를 수행하기 위해 초기값 세팅
		Queue<int[]> q = new LinkedList<>();
		int[][] count = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		q.add(new int[] {1, 1});
		count[1][1]=1;
		visited[1][1]=true;
		
		while(!q.isEmpty()) {
			int[] start = q.poll();
			int x = start[0];
			int y = start[1];
			for(int i=0; i<4; i++) {
				int newX = start[0]+dx[i];
				int newY = start[1]+dy[i];
				
				// 범위를 벗어난 경우 제외
				if(newX<1 || newY <1 || newX>N || newY>M)continue;
				// 막혀있는 경우 제외
				else if(map[newX][newY]==0) continue;
				// 이미 방문했을 경우
				else if(visited[newX][newY]) continue;
				else {
					q.add(new int[] {newX, newY});
					count[newX][newY]=count[x][y]+1;
					visited[newX][newY]=true;
				}
			}
		}
		System.out.println(count[N][M]);
	}
}
