
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연산의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 값을 저장할 priorityQueue 선언
		Queue<Integer> pq = new PriorityQueue<>();
		
		// 연산 반복
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			// 0이 주어질 때
			if(temp==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else System.out.println(pq.poll());
			}
			// 0이 아닐 때
			else pq.add(temp);
		}
	}
	
}