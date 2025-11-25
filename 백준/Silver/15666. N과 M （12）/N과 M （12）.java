
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> nums = new ArrayList<>();
    static int[] result; // 출력할 값을 담을 배열 (add/remove 불필요)
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 중복 제거 및 정렬 (TreeSet 이용)
        st = new StringTokenizer(br.readLine());
        Set<Integer> distinctNums = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            distinctNums.add(Integer.parseInt(st.nextToken()));
        }
        nums.addAll(distinctNums); // List로 변환

        // 결과 담을 배열 초기화
        result = new int[M];

        // 탐색 시작 (깊이 0, 인덱스 0부터)
        dfs(0, 0);

        System.out.println(sb);
    }

    // depth: 현재 담은 개수, start: 탐색 시작 인덱스 (비내림차순 유지용)
    public static void dfs(int depth, int start) {
        // 1. 종료 조건: M개를 모두 골랐을 때
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 2. 탐색 로직
        // start부터 시작하여 비내림차순 유지 + 같은 수 중복 선택 가능
        for (int i = start; i < nums.size(); i++) {
            result[depth] = nums.get(i); // 현재 깊이의 값을 덮어씌움 (add/remove 불필요)
            dfs(depth + 1, i); // 다음 깊이로 이동 (i를 그대로 넘겨서 중복 허용)
        }
    }
}