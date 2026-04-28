import java.util.*;

class Solution {
    List<Integer>[] winGraph;
    List<Integer>[] loseGraph;
    boolean[] visited;

    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 1. 인접 리스트 초기화
        winGraph = new ArrayList[n + 1];
        loseGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        // 2. 승패 관계 데이터 삽입
        for (int[] result : results) {
            winGraph[result[0]].add(result[1]);
            loseGraph[result[1]].add(result[0]);
        }

        // 3. 각 선수별로 DFS 수행
        for (int i = 1; i <= n; i++) {
            // 이긴 사람 수 카운트 (자기 자신 제외를 위해 -1)
            visited = new boolean[n + 1];
            int winCount = dfs(i, winGraph);
            
            // 진 사람 수 카운트 (자기 자신 제외를 위해 -1)
            visited = new boolean[n + 1];
            int loseCount = dfs(i, loseGraph);

            // (나보다 아래인 사람) + (나보다 위인 사람) == n - 1 이면 순위 확정
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    // 연결된 노드의 개수를 반환하는 DFS (재귀 방식)
    private int dfs(int current, List<Integer>[] graph) {
        visited[current] = true;
        int count = 0;

        for (int next : graph[current]) {
            if (!visited[next]) {
                // 연결된 노드 하나당 1을 더하고, 그 다음 노드의 결과값들을 합산
                count += 1 + dfs(next, graph);
            }
        }
        return count;
    }
}