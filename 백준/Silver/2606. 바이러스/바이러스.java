
import java.util.*;
import java.io.*;
public class Main{

	static int count =0;
	static List<Integer>[] node;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		// 컴퓨터의 수 N
		int N = Integer.parseInt(br.readLine());
		// 연결 된 수 M
		int M = Integer.parseInt(br.readLine());
		
		// 노드 선언
		node = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			node[i]=new ArrayList<>();
		}
		
		// 각 컴퓨터가 연결되어 있는 지 체크하는 배열 생성
		visit = new boolean[N+1];
		
		
		// 노드 연결하기
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			node[start].add(end);
			node[end].add(start);
		}
		
		dfs(1);
		System.out.println(count-1);
	}
	
	public static void dfs(int num) {
		// 방문했으므로
		visit[num]=true;
		count++;
		for(int next : node[num]) {
			if(!visit[next])dfs(next);
		}
	}
}
