

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
    static List<Integer> temp;
    static List<Integer> nums = new ArrayList<>();
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       
       // N과 M
       st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       
       // N개의 수
       st = new StringTokenizer(br.readLine());
       Set<Integer> s = new TreeSet<>();
       for(int i=0; i<N; i++) {
    	   s.add(Integer.parseInt(st.nextToken()));
       }
       
       for(int num : s) {
    	   nums.add(num);
       }
       
       for(int i=0; i<nums.size(); i++) {
    	   temp = new ArrayList<>();
    	   dfs(i);
       }
       System.out.println(sb);
    }
    
    public static void dfs(int start) {
    	temp.add(nums.get(start));
    	if(temp.size()==M) {
    		for(int num : temp) {
    			sb.append(num+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i=start; i<nums.size(); i++) {
    		dfs(i);
    		temp.remove(temp.size()-1);
    	}
    }
}