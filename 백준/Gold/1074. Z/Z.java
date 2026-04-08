import java.util.*;
import java.io.*;

public class Main {
    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 2^N을 비트 시프트 연산으로 간단히 표현
        solve(0, 0, 1 << N);
    }

    static void solve(int x, int y, int n) {
        if (n == 1) {
            System.out.println(count);
            // 정답을 찾으면 즉시 종료하여 불필요한 재귀 스택을 방지합니다.
            System.exit(0);
        }

        int half = n / 2;
        int size = half * half;

        // 사분면 판별 및 재귀 호출
        if (r < x + half && c < y + half) {
            // 1사분면
            solve(x, y, half);
        } else if (r < x + half && c >= y + half) {
            // 2사분면: 1개 구역만큼 건너뜀
            count += size;
            solve(x, y + half, half);
        } else if (r >= x + half && c < y + half) {
            // 3사분면: 2개 구역만큼 건너뜀
            count += size * 2;
            solve(x + half, y, half);
        } else {
            // 4사분면: 3개 구역만큼 건너뜀
            count += size * 3;
            solve(x + half, y + half, half);
        }
    }
}