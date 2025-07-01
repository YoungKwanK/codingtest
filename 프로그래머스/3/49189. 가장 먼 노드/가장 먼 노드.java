import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] count;
    // bfs를 위한 큐 선언
    static Queue<Integer> q;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 그래프 초기화
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        // 그래프 그리기(양방향 간선 연결)
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        // bfs를 위한 큐 선언
        q = new LinkedList<>();
        visited= new boolean[n+1];
        // 1번 노드에서 가장 멀리 떨어진 노드의 갯수이므로 1부터 시작
        count = new int[n+1];
        q.add(1);
        visited[1]=true;
        bfs();
        Arrays.sort(count);
        int max=count[n];
        for(int i=1; i<=n; i++){
            if(count[i]==max) answer++;
        }
        
        return answer;
    }
    static void bfs(){
        if(q.isEmpty()) return;
        int temp = q.poll();
        for(int num : graph.get(temp)){
            if(!visited[num]){
                q.add(num);
                visited[num]=true;
                count[num]=count[temp]+1;
            }
        }
        bfs();
    }
}