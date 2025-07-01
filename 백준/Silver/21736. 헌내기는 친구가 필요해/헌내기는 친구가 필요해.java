
import java.util.*;
import java.io.*;
public class Main{
	static String[][] campus;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		// 캠퍼스의 크기 N과 M
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 캠퍼스의 크기 초기화
		campus = new String[N][M];
		
		// 캠퍼스 정보 넣기
		int startX = 0;
		int startY = 0;
		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<M; j++) {
				campus[i][j]=temp[j];
				// 시작 위치(도연이 위치) 저장
				if(temp[j].equals("I")) {
					startX=j;
					startY=i;
				}
			}
		}
		
		visited = new boolean[N][M];
		// dfs 수행
		dfs(startX, startY);
		// 아무도 안만나면
		if(count==0) System.out.println("TT");
		// 만난 사람이 있으면
		else System.out.println(count);
	}
	public static void dfs(int x, int y) {
		// 사람을 만나면
		if(campus[y][x].equals("P")) count++;
		visited[y][x]=true;
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			// campus밖으로 넘어가면 예외처리
			if(newX<0 || newY <0 || newY>=campus.length || newX>=campus[0].length) {
				continue;
			}
			// 벽만나는 경우 제외
			else if(campus[newY][newX].equals("X")) {
				continue;
			}
			// 이미 방문한 경우 제외
			else if(visited[newY][newX]) {
				continue;
			}
			else {
				dfs(newX, newY);
			}
		}
	}
}