

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 수의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 합을 구해야 하는 횟수 M
        int M = Integer.parseInt(st.nextToken());
        
        // 누적합
        int[] prefix=new int[N+1];
        
        // 수 받기
        st=new StringTokenizer(br.readLine());
        int[] nums = new int[N+1];
        for(int i=1; i<nums.length; i++) {
        	nums[i]=Integer.parseInt(st.nextToken());
        	prefix[i]=prefix[i-1]+nums[i];
        }
        int start;
        int end;
        for(int i=0; i<M; i++) {
        	st=new StringTokenizer(br.readLine());
        	start = Integer.parseInt(st.nextToken());
        	end = Integer.parseInt(st.nextToken());
        	System.out.println(prefix[end]-prefix[start-1]);
        }
        
    }
}
