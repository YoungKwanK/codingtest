
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        // 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 가방에 넣기
        List<Item> bag = new ArrayList<>();
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	// 무게와 가치 넣기
        	bag.add(new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        
        // dp 테이블 정의
        int[] dp = new int[K+1];    
        
        for(int i=0; i<N; i++) {
        	// 물건 하나씩 꺼내기
    		Item temp = bag.get(i);
    		// 물건을 추가하기 전의 최대와 비교
    		for (int w = K; w >= temp.weight; w--) {
    	        dp[w] = Math.max(dp[w], dp[w - temp.weight] + temp.value);
    	    }
        }
        int answer=dp[K];
        System.out.println(answer);
    }
}
class Item{
	int weight;
	int value;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}