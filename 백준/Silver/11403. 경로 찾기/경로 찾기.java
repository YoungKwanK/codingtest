
import java.util.*;
import java.io.*;
public class Main{
	
	static List<Integer>[] map;
	static boolean[] visited;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//  정점의 개수 N (1 ≤ N ≤ 100)
		int N = Integer.parseInt(br.readLine());
		
		// 간선 만들기
		int[][] e = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				e[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 간선 연결
		map = new List[N+1];
		for(int i=1; i<N+1; i++) {
			map[i]=new ArrayList<>();
			for(int j=1; j<N+1; j++) {
				// 연결이 있으면
				if(e[i][j]==1) {
					// 단반향 연결
					map[i].add(j);
				}
			}
		}
		

		StringBuilder sb = new StringBuilder();
		// bfs 모든 노드 간에 시작 bfs(시작노드, 타겟노드)
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				visited = new boolean[N+1];
				check = false;
				dfs(i, j);
				if(check) {
					sb.append(1).append(" ");
				}else sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int start, int target) {
		visited[start] = true;
		for(int i : map[start]) {
			if(i==target) check=true;
			if(!visited[i]) dfs(i, target);
		}
		
	}
	
}
