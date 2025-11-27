
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        result = new int[M]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1; 

        for (int i = 0; i < N; i++) {
        	
            if (visited[i]) continue;

            if (before == nums[i]) continue;

            visited[i] = true;     
            result[depth] = nums[i]; 
            before = nums[i];     

            dfs(depth + 1);         

            visited[i] = false;     
        }
    }
}