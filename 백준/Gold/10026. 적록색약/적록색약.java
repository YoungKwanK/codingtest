
import java.util.*;
import java.io.*;
public class Main{
	static char[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int count1=0;
	static int count2=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N (1 ≤ N ≤ 100)
		int N = Integer.parseInt(br.readLine());
		map=new char[N][N];
		visited1=new boolean[N][N];
		visited2=new boolean[N][N];
		
		// 색 받기
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited1[i][j]) continue;
				dfs1(i,j);
				count1++;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited2[i][j]) continue;
				dfs2(i,j);
				count2++;
			}
		}
		
		System.out.println(count1 + " " + count2);
		
	}
	static void dfs1(int x, int y) {
		visited1[x][y]=true;
		char color = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위를 벗어나는 경우 제외
			if(nx<0 || ny<0 || nx >= map.length || ny >= map[0].length) continue;
			// 이미 방문한 경우 예외
			else if(visited1[nx][ny]) continue;
			// 다른 색이 나온 경우
			else if(map[nx][ny]!=color) continue;
			else {
				dfs1(nx, ny);
			}
			
		}
	}
	static void dfs2(int x, int y) {
		visited2[x][y]=true;
		char color = map[x][y];
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위를 벗어나는 경우 제외
			if(nx<0 || ny<0 || nx >= map.length || ny >= map[0].length) continue;
			// 이미 방문한 경우 예외
			else if(visited2[nx][ny]) continue;
			else {
				// 다른 색이 나온 경우
				if(color=='R' || color=='G') {
					if(map[nx][ny]=='B')continue;
				}
				else if(map[nx][ny]!=color) continue;
				dfs2(nx, ny);
			}
			
		}
	}
}
