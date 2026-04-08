import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        int startX = 0;
        int startY = 0;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                    answer[i][j] = 0;
                } else if (map[i][j] == 0) {
                    answer[i][j] = 0; 
                } else {
                    answer[i][j] = -1; // 방문하지 않은 갈 수 있는 땅 초기화
                }
            }
        }

        // LinkedList 대신 ArrayDeque 사용
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 방문하지 않았고(-1), 갈 수 있는 땅(1)인 경우만 탐색
                    if (answer[nx][ny] == -1 && map[nx][ny] == 1) {
                        answer[nx][ny] = answer[curr[0]][curr[1]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}