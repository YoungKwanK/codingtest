
import java.util.*;
import java.io.*;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 정점의 수 N
        N = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        graph = new int[N][N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 각 정점에 대해 dfs 수행
        for(int i=0; i<N; i++) {
        	visited = new boolean[N];
        	dfs(i);
        	
        	// 방문(길이 있었으면) 저장
        	for(int j=0; j<N; j++) {
        		if(visited[j]) sb.append("1 ");
        		else sb.append("0 ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void dfs(int k) {
    	for(int i=0; i<N; i++) {
    		// 방문했거나, 길이 없으면 넘기기
    		if(visited[i] || graph[k][i] == 0) continue;
    		else {
    			visited[i] = true;
    			dfs(i);
    		}
    	}
    }
}