import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int maxSum = 0;
    static int maxVal = 0; // 가지치기를 위한 격자 내 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        // 격자 입력 받기 및 최댓값 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Math.max(maxVal, board[i][j]);
            }
        }

        // 모든 좌표를 시작점으로 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1. DFS 탐색 (ㅗ 모양 제외)
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false; // 백트래킹

                // 2. ㅗ 모양 탐색
                checkTShape(i, j);
            }
        }

        System.out.println(maxSum);
    }

    // 1. DFS 메서드
    static void dfs(int x, int y, int depth, int sum) {
        // [핵심] 가지치기: 남은 블록을 모두 최댓값으로 더해도 현재 maxSum보다 작다면 탐색 중지
        if (sum + (4 - depth) * maxVal <= maxSum) {
            return;
        }

        // 4칸을 모두 탐색한 경우
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 격자 범위 내에 있고, 방문하지 않은 칸이라면
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // 2. 'ㅗ' 모양 탐색 메서드
    static void checkTShape(int x, int y) {
        int sum = board[x][y];
        int wings = 0;        // 뻗어나간 날개 개수
        int minWing = 10001;  // 날개 중 가장 작은 값 (문제 조건상 숫자는 1000 이하)

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                wings++;
                sum += board[nx][ny];
                minWing = Math.min(minWing, board[nx][ny]);
            }
        }

        // 십자가 모양(날개 4개)인 경우, 가장 값이 작은 날개를 하나 잘라내서 'ㅗ' 모양으로 만듦
        if (wings == 4) {
            sum -= minWing;
            maxSum = Math.max(maxSum, sum);
        } 
        // 날개가 3개인 경우 (격자 가장자리라서 이미 'ㅗ', 'ㅏ', 'ㅓ', 'ㅜ' 중 하나가 완성됨)
        else if (wings == 3) {
            maxSum = Math.max(maxSum, sum);
        }
    }
}