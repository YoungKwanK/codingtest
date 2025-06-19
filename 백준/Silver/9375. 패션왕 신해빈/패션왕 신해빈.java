
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        // 테스트 케이스만큼 반복
        for(int i=0; i<T; i++) {
        	// 의상의 수
        	int n = Integer.parseInt(br.readLine());
        	
        	// 의상이 없으면 0출력하고 다음 테스트 케이스 수행
        	if(n==0) {
        		System.out.println(0);
        		continue;
        	}
        	
        	// 종류에 따른 의상 수를 담을 Map 선언
        	Map<String, Integer> cloth = new HashMap<>();
        	
        	for(int j=0; j<n; j++) {
        		String[] temp = br.readLine().split(" ");
        		// 옷 종류가 없으면 0 있으면 +1 -> 종류에 따른 의상 수 카운트
        		cloth.put(temp[1], cloth.getOrDefault(temp[1],0)+1);
        	}
        	int result=1;
        	for(String wear : cloth.keySet()) {
        		result*=(cloth.get(wear)+1);
        	}
        	System.out.println(result-1);
        }
    }
}
