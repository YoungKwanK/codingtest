import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 답을 저장할 변수
		int answer=0;
		
		// bfs를 사용할 자료구조
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][] = new boolean[M][N];
		
		// 이동할 수 있는 위치 
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		// 처음부터 다 채워져있을 경우
		boolean check = false;
		// 토마토의 위치 저장
		int[][] tomatoes = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				tomatoes[i][j]=Integer.parseInt(st.nextToken());
				// 토마토가 있는 자리 큐에 넣기
				if(tomatoes[i][j]==1) {
					// x, y, count
					int[] temp = {i,j};
					q.add(temp);
					visited[i][j]=true;
				}
				if(tomatoes[i][j]==0) check=true;
			}
		}
		
		if(!check) {
			System.out.println(0);
			return;
		}
		
		while(!q.isEmpty()) {
			int[] tomato = q.poll();
			int x = tomato[0];
			int y = tomato[1];
			// 상, 하, 좌, 우 
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				// 범위를 벗어나는 경우
				if(nx<0 || ny<0 || nx>=tomatoes.length || ny>=tomatoes[0].length) continue;
				// 비어있는 경우
				else if(tomatoes[nx][ny]==-1) continue;
				// 이미 방문한 경우
				else if(visited[nx][ny]) continue;
				else {
					int[] temp = {nx, ny};
					q.add(temp);
					tomatoes[nx][ny]=tomatoes[x][y]+1;
					visited[nx][ny]=true;
				}
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				answer = Math.max(answer, tomatoes[i][j]);
				if(tomatoes[i][j]==0) {
					// 모두 익지는 못하는 경우
					System.out.println(-1);
					return;
				}
			}
		}
//		처음 토마토를 넣을 때 1이 들어가므로 1빼기
		System.out.println(answer-1);
	}
}