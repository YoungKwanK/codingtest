
import java.util.*;
import java.io.*;

public class Main {
	
	static int K;
	static List<List<Integer>> answers = new ArrayList<>();
	static List<Integer> nums;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        // 테스트 케이스의 갯수가 안정해져있으므로 무한 반복
        while(true) {
        	// 테스트 케이스 입력받기
        	st = new StringTokenizer(br.readLine());
        	// 테스트의 갯수 K
        	int K = Integer.parseInt(st.nextToken());
        	// 0이 하나 주어질 경우 종료
        	if(K==0) {
        		break;
        	}
        	// 입력받은 값을 list에 넣기
        	nums = new ArrayList<>();
        	for(int i=0; i<K; i++) {
        		nums.add(Integer.parseInt(st.nextToken()));
        	}
        	combi(new ArrayList<>(),0);
        	
        	// Stringbuilder에 저장
        	for(int i=0; i<answers.size(); i++) {
        		for(int j=0; j<answers.get(i).size(); j++) {
        			sb.append(answers.get(i).get(j)).append(" ");
        		}
        		sb.append("\n");
        	}
        	sb.append("\n");
        	answers.clear();
        }
        // 답 출력
        System.out.println(sb);
        
    }
    // 재귀 함수 - 조합
    static void combi(ArrayList<Integer> temp, int start) {
    	if(temp.size()==6) {
    		answers.add(new ArrayList<>(temp));
    		return;
    	}
    	for(int i=start; i<nums.size(); i++) {
    		temp.add(nums.get(i));
    		combi(temp, i+1);
    		temp.remove(temp.size()-1);
    	}
    }
}
