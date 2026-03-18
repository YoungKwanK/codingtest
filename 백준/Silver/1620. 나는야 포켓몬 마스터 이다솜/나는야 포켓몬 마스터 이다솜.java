
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	// N과 M 받기
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	// map 선언하고 포켓몬 도감 만들기
    	Map<String, String> poketmon = new HashMap<>();
    	for(int i=1; i<=N; i++) {
    		String temp = br.readLine(); 
    		poketmon.put(String.valueOf(i), temp);
    		poketmon.put(temp, String.valueOf(i));
    	}
    	
    	// 도감에서 찾기
    	for(int i=0; i<M; i++) {
    		String find = br.readLine();
			sb.append(poketmon.get(find)).append("\n");
    	}
    	System.out.println(sb);
    }
}