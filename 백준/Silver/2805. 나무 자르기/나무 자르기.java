
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 나무 수 N과 집으로 가져가려는 나무 길이 M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각각의 나무 길이 받기
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) max = trees[i];
        }

        int min = 0;
        int answer = 0;

        // 이분 탐색
        while (min <= max) {
            int mid = (min + max) / 2;
            long total = 0; // 합이 클 수 있으므로 long으로

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) total += trees[i] - mid;
            }

            if (total >= M) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
