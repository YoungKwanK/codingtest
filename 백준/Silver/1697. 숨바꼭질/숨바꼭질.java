
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수빈이가 있는 위치 N과 동생이 있는 위치 K
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 테이블 정의
		int[] map = new int[100001];
		
		// 초기값 세팅 - 동생의 위치 제외하고 모두 0
		map[K]=1;
		boolean[] visited = new boolean[100001];
		int[] count=new int[100001];
		
		// bfs를 수행할 queue 만들기
		Queue<Integer> bfs = new LinkedList<>();
		// bfs 시작
		bfs.add(N);
		visited[N]=true;
		while(!bfs.isEmpty()) {
			int x = bfs.poll();
			if(map[x]==1) {
				System.out.println(count[x]);
				break;
			}
			int[] newX= {x+1, x-1, x*2};
			for(int i=0; i<newX.length; i++) {
				// 맵을 벗어날 경우
				if(newX[i]<0 || newX[i]>=map.length) continue;
				// 이미 방문한 곳일 경우
				else if(visited[newX[i]]) continue;
				else {
					bfs.add(newX[i]);
					count[newX[i]]=count[x]+1;
					visited[newX[i]]=true;
				}
			}
		}
	}
}
