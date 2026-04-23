import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 초깃값 세팅
        ArrayList<Integer>[] vertex = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            vertex[i] = new ArrayList<>();
        }
        int []visited = new int[n+1];
        
        // 간선 양방향 연결
        for(int i=0; i<edge.length; i++){
            vertex[edge[i][0]].add(edge[i][1]);
            vertex[edge[i][1]].add(edge[i][0]);
        }
        
        // bfs
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(1);
        visited[1]=1;
        while(!bfsQ.isEmpty()){
            int node = bfsQ.poll();
            
            for(int i : vertex[node]){
                if(visited[i]==0){
                    visited[i] = visited[node]+1;
                    bfsQ.add(i);
                }   
            }
        }
        
        // 최대 거리 찾기 및 개수 세기
        int max = 0;
        for (int i : visited) {
            if (i > max) max = i;
        }

        for (int i : visited) {
            if (i == max) answer++;
        }
        
        return answer;
    }
}