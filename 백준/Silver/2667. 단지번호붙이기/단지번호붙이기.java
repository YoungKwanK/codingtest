
import java.util.*;
import java.io.*;
public class Main{
	// 지도 초기화
	static int[][] map;
	// 방문했는 지 확인할 변수
	static boolean[][] visited;
	// 단지별 수를 저장할 List
	static List<Integer> count;
	// 이동의 방향을 결정 할 dx, dy
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	// 단지의 합을 저장할 변수
	static int sum=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)
		int N = Integer.parseInt(br.readLine());
		
		// 지도 그리기 
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			// 띄어쓰기 없이 한줄씩 들어옴으로
			String[] temp = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(temp[j]);
			}
		}
		
		// 초기값 세팅
		visited = new boolean[N][N];
		count = new ArrayList<>();
		
		// 모든 위치에 dfs 시작
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 해당 위치에 집이 없거나 방문했던 경우 넘어가기
				if(map[i][j]==0 || visited[i][j]) continue;
				else {
					sum=0;
					bfs(i, j);
					count.add(sum);
				}
			}
		}
		
		// 정답 출력
		System.out.println(count.size());
		Collections.sort(count);
		for(int i : count) {
			System.out.println(i);
		}
		
	}
	static void bfs(int x, int y) {
		sum++;
		visited[x][y]=true;
		// 이동할 위치
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			// 지도를 벗어날 경우 제외
			if(nx<0 || ny<0 || nx>map.length-1 || ny>map[0].length-1)continue;
			// 새 위치가 빈집이면 제외
			else if(map[nx][ny]==0) continue;
			// 새 위치가 이미 방문했으면 제외
			else if(visited[nx][ny]) continue;
			else {
				bfs(nx, ny);
			}
		}
	}
}
