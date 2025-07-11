
import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H
		// 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N =Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		// 토마토를 저장할 크기 설정
		int[][][] boxes = new int[H][N][M];
		
		// 탐색을 위한 방향 배열
		int[] dx = {1,-1,0,0,0,0};
		int[] dy = {0,0,1,-1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		// 방문했는 지 확인할 배열
		boolean[][][] visited = new boolean[H][N][M];
		
		// 일 수를 저장할 배열
		int[][][] count = new int[H][N][M];
		
		// bfs를 진행할 queue, 인덱스 0은 z, 1은 y, 2는 x
		Queue<int[]> bfs = new LinkedList<>();
		
		// 토마토 받기 - 1이 있는 지 확인하고 없으면 어차피 모두 익지 못하므로 -1 출력하고 종료
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					boxes[i][j][k] = Integer.parseInt(st.nextToken());
					if(boxes[i][j][k]==1) {
						bfs.add(new int[] {i, j, k});
						visited[i][j][k]=true;
					}
				}
			}
		}
		// bfs 수행
		while(!bfs.isEmpty()) {
			int[] temp = bfs.poll();
			int h =temp[0];
			int y = temp[1];
			int x = temp[2];
			
			// 위치 이동
			for(int l=0; l<6; l++) {
				int nh = h + dz[l];
				int ny = y + dy[l];
				int nx = x + dx[l];
				
				// 상자밖의 범위 예외처리
				if(nh < 0 || ny < 0 || nx < 0 || nh >=boxes.length || ny >= boxes[0].length || nx >= boxes[0][0].length) continue;
				// 이미 방문한 경우
				else if(visited[nh][ny][nx]) continue;
				// 다음 위치가 익지 않는 토마토가 아닐 경우(1이면 어차피 탐색할거니까, -1은 못감)
				else if(boxes[nh][ny][nx]!=0) continue;
				else {
					visited[nh][ny][nx] = true;
					bfs.add(new int[] {nh, ny, nx});
					count[nh][ny][nx]=count[h][y][x]+1;
				}
			}
		}
		int answer = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					// 방문하지 않았고 토마토가 익지 않았으면 모두 익지는 못하는 상황
					if(!visited[i][j][k] && boxes[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
					// 제일 큰 count값
					answer = Math.max(answer, count[i][j][k]);
				}
			}
		}
		System.out.println(answer);
		
	}
}
