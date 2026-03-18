
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 듣도 못한 수 N, 보도 못한 수 M
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	// 이름을 저장할 맵 선언
    	Map<String, Integer> people = new TreeMap<>();
    	
    	// 이름 넣기
    	for(int i=0; i<N+M; i++) {
    		String name = br.readLine();
    		people.put(name, people.getOrDefault(name, 0)+1);
    	}
    	
    	int result=0;
    	StringBuilder sb = new StringBuilder();
    	for(String name : people.keySet()) {
    		if(people.get(name)==2) {
    			result++;
    			sb.append(name).append("\n");
    		}	
    	}
    	
    	System.out.println(result);
    	System.out.println(sb);
    }
}