
import java.util.*;
import java.io.*;
public class Main{
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	static boolean[][] visited;
	static int max=0;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 종이의 세로 크기 N과 가로 크기 M (4 ≤ N, M ≤ 500)
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 종이에 점수 넣기
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j]=true;
				dfs(i, j, map[i][j],1);
				visited[i][j]=false;
				checkExtraShape(i,j);
			}
		}
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int sum, int count) {
		if(count==4) {
			max=Math.max(max,sum);
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
//			범위를 벗어나느 경우
			if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length) continue;
//			이미 방문한 경우 제외
			else if(visited[nx][ny]) continue;
			else {
				visited[nx][ny]=true;
				dfs(nx,ny,sum+map[nx][ny], count+1);
				visited[nx][ny]=false;
			}
		}
	}
	 public static void checkExtraShape(int x, int y){
	        // 중심(x, y) 기준
	        // ㅗ
	        if(x >= 0 && x+1 < N && y-1 >= 0 && y+1 < M)
	            max = Math.max(max, map[x][y] + map[x+1][y] + map[x][y-1] + map[x][y+1]);
	        // ㅜ
	        if(x-1 >= 0 && x < N && y-1 >= 0 && y+1 < M)
	            max = Math.max(max, map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1]);
	        // ㅏ
	        if(x-1 >= 0 && x+1 < N && y+1 < M)
	            max = Math.max(max, map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y+1]);
	        // ㅓ
	        if(x-1 >= 0 && x+1 < N && y-1 >= 0)
	            max = Math.max(max, map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1]);
	    }
}