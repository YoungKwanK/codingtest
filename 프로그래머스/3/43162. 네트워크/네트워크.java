import java.util.*;
class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer=0;
    
    public int solution(int n, int[][] computers) {
        
        // 초깃값 세팅
        visited = new boolean[n];
        graph = new ArrayList[n];
        
        // 간선 연결
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(computers[i][j]==1) temp.add(j);
            }
            graph[i]=temp;
        }
        
        // 모든 정점에 대해서 dfs
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int start){
        for(int i : graph[start]){
            if(!visited[i]){
                visited[i]=true;
                dfs(i);
            }
        }
    }
}