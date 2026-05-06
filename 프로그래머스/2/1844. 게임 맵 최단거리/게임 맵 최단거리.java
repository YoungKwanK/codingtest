import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;  
        int m = maps[0].length; 
        
        // 상하좌우 이동을 위한 방향 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 방문 여부와 거리를 동시에 저장할 배열
        int[][] visited = new int[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 설정
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 목표 지점 도달 시 즉시 반환 (효율성)
            if (x == n - 1 && y == m - 1) {
                return visited[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 1. 범위를 벗어나는지 확인
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 2. 벽(0)이거나 이미 방문했는지 확인
                if (maps[nx][ny] == 0 || visited[nx][ny] != 0) continue;

                // 방문 처리 및 거리 갱신
                visited[nx][ny] = visited[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }

        // 도달할 수 없는 경우
        return -1;
    }
}