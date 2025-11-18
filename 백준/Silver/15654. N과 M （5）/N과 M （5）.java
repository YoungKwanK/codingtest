

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 크기 초기화
        nums = new int[N];
        result = new int[M];
        visited = new boolean[N];

        // N개의 수 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(nums);

        // 로직 수행
        dfs(0);
        System.out.println(sb);
    }

    // 깊이 우선 탐색
    public static void dfs(int depth) {
        // M개를 골랐을 때 다음 수로 이동
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;      // 방문 체크
                result[depth] = nums[i]; // 현재 깊이에 값 저장
                
                dfs(depth + 1);         // 다음 깊이로 이동
                
                visited[i] = false;     // 백트래킹 (방문 체크 해제)
            }
        }
    }
}