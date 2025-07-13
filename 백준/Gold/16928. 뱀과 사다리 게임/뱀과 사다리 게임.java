
import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 사다리의 수 N(1 ≤ N ≤ 15)과 뱀의 수 M(1 ≤ M ≤ 15)
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 지도 그리기
		int[] map = new int[101]; 
		
		// N개의 줄에는 사다리의 정보를 의미하는 x, y (x < y)가 주어진다. x번 칸에 도착하면, y번 칸으로 이동
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map[x]=y;
		}
		// M개의 줄에는 뱀의 정보를 의미하는 u, v (u > v)
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			map[u]=v;
		}
		
		// bfs 초깃값 세팅
		boolean[] visited = new boolean[101];
		Queue<Integer> q = new LinkedList<>();
		int[] count = new int[101];
		
		// bfs 시작
		q.add(1);
		visited[1]=true;
		count[1]=0;
		while(!q.isEmpty()) {
			int start = q.poll();
			if(start==100) {
				System.out.println(count[100]);
				return;
			}
			for(int i=1; i<=6; i++) {
				// 범위를 벗어나는 경우 제외
				if(start+i>100) continue;
				// 이미 방문한 경우 제외
				else if(visited[start+i]) continue;
				else {
					visited[start+i] = true;
					count[start+i]=count[start]+1;
					// 해당 위치에 사다리나 뱀이 있을 경우
					if(map[start+i]!=0) {
						if(!visited[map[start+i]]) {
							q.add(map[start+i]);
							visited[map[start+i]]=true;
							count[map[start+i]]=count[start+i];
						}
					// 없으면
					}else {
						q.add(start+i);
					}
				}
			}
		}
	}
}
