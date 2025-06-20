
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받을 점의 개수
        int N = Integer.parseInt(br.readLine());

        // y 범위: -100000 ~ 100000 → 배열 인덱스 0 ~ 200000
        ArrayList<Integer>[] nums = new ArrayList[200001];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new ArrayList<>();
        }

        // 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nums[y + 100000].add(x); // y를 0 기준으로 shift
        }

        // 각 y별로 x 정렬
        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].isEmpty()) {
                Collections.sort(nums[i]);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int y = i - 100000; // 다시 원래 y값으로 복원
            for (int x : nums[i]) {
                sb.append(x).append(" ").append(y).append("\n");
            }
        }

        System.out.print(sb);
    }
}
