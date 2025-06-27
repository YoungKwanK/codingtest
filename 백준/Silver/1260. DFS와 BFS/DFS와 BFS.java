
import java.util.*;
import java.io.*;
public class Main{
	// 그래프
	static Set<Integer>[] graph;
	// 방문
	static boolean[] visit;
	// 정답을 저장할 문자열
	static StringBuilder sb = new StringBuilder();
	static // bfs를 사용하기 위해 Queue 사용
	Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 정점의 수 N, 간선의 수 M, 시작할 정점의 번호 Y받기
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new Set[N+1];
		for(int i=0; i<N+1; i++) {
			// 작은 것을 먼저 방문이므로 tree set
			graph[i] = new TreeSet<>();
		}
		
		int start;
		int end;
		// 간선 받아 그래프 그리기
		for(int i=0; i<M; i++) {
			// 간선 받기
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end=Integer.parseInt(st.nextToken());
			
			// 노드에 간선 연결, 양방향임으로 양쪽 연결
			graph[start].add(end);
			graph[end].add(start);
		}
		
		// visit은 알고리즘마다 다르므로 초기화를 따로 해줌
		visit = new boolean[N+1];
		//dfs 수행
		dfs(Y);
		
		sb.append("\n");
		visit = new boolean[N+1];
		// bfs수행
		q.add(Y);
		visit[Y]=true;
		bfs();
		System.out.println(sb);
	}
	
	static void dfs(int Y) {
		if(visit[Y]) return;
		visit[Y] = true;
		sb.append(Y).append(" ");
		for(int i : graph[Y]) {
			dfs(i);
		}
		
	}
	static void bfs() {
		if(q.isEmpty()) return;
		int temp = q.poll();
		sb.append(temp).append(" ");
		for(int i : graph[temp]) {
			if(!visit[i]) { 
				q.add(i);
				visit[i]=true;
			}
		} 
		bfs();
	}
	
}
