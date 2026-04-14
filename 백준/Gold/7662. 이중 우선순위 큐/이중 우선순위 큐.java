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
			int k = Integer.parseInt(br.readLine());
			
			// 순서가 있는 Map 
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			
			// 연산의 수만큼 반복
			for(int i=0; i<k; i++) {
				st= new StringTokenizer(br.readLine());
				// 연산을 문자로 변환
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				// I면 추가
				if(c=='I') {
					tm.put(num, tm.getOrDefault(num,0)+1);
					// D일 때
				}else {
				// 비어있으면 넘기기
					if(tm.isEmpty()) continue;
					// 최댓값 제거할 지, 최솟값 제거할 지
					int targetKey = (num == 1) ? tm.lastKey() : tm.firstKey();
					int count = tm.get(targetKey);
					
					if (count == 1) {
					    tm.remove(targetKey);
					} else {
					    tm.put(targetKey, count - 1);
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
