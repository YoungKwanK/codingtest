
import java.util.*;
import java.io.*;

public class Main {
	static List<List> answers = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // N과 M 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 중복을 제거하기 위한 visit
        boolean[] visit = new boolean[N+1];
        
        // 수열 구하는 메서드 수행
        permu(N, M, new ArrayList<>(), visit);
        
        // 값을 한번에 출력하기 위한 
        StringBuilder sb = new StringBuilder();
        for(List<Integer> answer : answers) {
        	for(int i=0; i<answer.size(); i++) {
        		sb.append(answer.get(i)).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
        
        
    }
    static void permu(int N, int M, List<Integer> temp, boolean[] visit) {
    	if(temp.size()==M) {
    		answers.add(new ArrayList<>(temp));
    		return;
    	}
    	for(int i=1; i<N+1; i++) {
    		if(!visit[i]) {
    			visit[i]=true;
    			temp.add(i);
    			permu(N, M, temp, visit);
    			visit[i]=false;
    			temp.remove(temp.size()-1);
    		}
    	}
    }
}
