
import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//   n은 세로의 크기, m은 가로의 크기(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// n개의 줄에 m개의 숫자 - 0은 갈 수 없는 땅, 1은 갈 수 있는 땅, 2는 목표지점, 입력에서 2는 단 한개
		// 목표 x, y 저장
		int targetX=0;
		int targetY = 0;
		int [][] map = new int[N][M];	// 맵 초기화
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					targetX=j;
					targetY=i;
				}
			}
		}
		br.close();
		
		// 가로 새로 이동을 결정할 배열
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		// bfs를 수행할 queue, 안의 배열은 0 = y좌표, 1=x좌표 2=count
		Queue<int[]> bfs = new LinkedList<>();;
		// 이미 방문한 지 확인할 배열
		boolean[][] visited = new boolean[N][M];
		
		// 결과를 저장할 이중 for문
		int[][] answer = new int[N][M];
		// 일단 모든 땅을 도달할 수 없는 위치로 지정
		for(int i=0; i<N; i++) {
			Arrays.fill(answer[i], -1);
		}
		
		
		// bfs 초기 세팅
		bfs.add(new int[] {targetY, targetX, 0});
		visited[targetY][targetX]=true;
		answer[targetY][targetX]=0;
		
		// 거리를 잴 count
		int count = 0;
		
		// bfs 연산 실행
		while(!bfs.isEmpty()) {
			// 하나씩 뽑기
			int[] start = bfs.poll();
			int y = start[0];
			int x = start[1];
			count=start[2];
			
			// 이동하기
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y+dy[k];
				// 맵을 벗어나면 예외
				if(nx<0 || ny<0 || ny>=map.length || nx>=map[0].length)  continue;
				// 이미 방문한 경우 예외
				else if(visited[ny][nx]) continue;
				// 원래 갈 수 없는 땅이면 정답에 0을 추가하고 예외
				else if(map[ny][nx]==0) {
					answer[ny][nx]=0;
					continue;
				}
				else {
					answer[ny][nx]=count+1;
					bfs.add(new int[] {ny, nx, count+1});
					visited[ny][nx]=true;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) answer[i][j]=0;
				System.out.print(answer[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
