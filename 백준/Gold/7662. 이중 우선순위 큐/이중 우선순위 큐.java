
import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			// Q에 적용할 연산의 개수를 나타내는 정수 k (k ≤ 1,000,000)
			int k = Integer.parseInt(br.readLine());
			
			// 테이블 정의, 숫자 : 갯수
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			
			// 연산의 수만큼 반복
			for(int i=0; i<k; i++) {
				st= new StringTokenizer(br.readLine());
				// 연산을 문자로 변환
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if(c=='I') {
					tm.put(num, tm.getOrDefault(num,0)+1);
				}else {
					if(tm.isEmpty()) continue;
					else if(num==1) {
						// treemap의 가장 큰 값 -1
						tm.put(tm.lastKey(), tm.get(tm.lastKey())-1);
						// treemap의 가장 큰 값이 0이면 제거
						if(tm.get(tm.lastKey())==0) tm.pollLastEntry();
					}
					else {
						// treemap의 가장 큰 값 -1
						tm.put(tm.firstKey(), tm.get(tm.firstKey())-1);
						// treemap의 가장 큰 값이 0이면 제거
						if(tm.get(tm.firstKey())==0) tm.pollFirstEntry();
					}
				}	
			}
			if(tm.isEmpty()) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(tm.lastKey()+" "+tm.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
