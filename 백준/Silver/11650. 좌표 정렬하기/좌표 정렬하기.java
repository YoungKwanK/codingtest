import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] point = new int[2];
            point[0] = Integer.parseInt(st.nextToken()); // x
            point[1] = Integer.parseInt(st.nextToken()); // y
            list.add(point);
        }

        // 정렬: x 오름차순, x 같으면 y 오름차순
        list = list.stream()
                .sorted(Comparator
                        .comparingInt((int[] p) -> p[0])
                        .thenComparingInt(p -> p[1]))
                .collect(Collectors.toList());

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int[] p : list) {
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        System.out.print(sb);
    }
}
