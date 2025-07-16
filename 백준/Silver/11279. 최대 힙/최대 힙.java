
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연산의 개수 N(1 ≤ N ≤ 100,000)
		int N = Integer.parseInt(br.readLine());
		
		// 테이블 정의
		Queue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);
		
		// 정답을 저장할 StringBuilder
		StringBuilder answer = new StringBuilder();
		
		while(N-->0) {
			int temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(pq.isEmpty()) {
					answer.append(0).append("\n");
				}else {
					answer.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(temp);
			}
		}
		br.close();
		System.out.println(answer);
	}
}
