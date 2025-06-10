
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 명령의 수 N 받기
		int N = Integer.parseInt(br.readLine());
		
		// 값을 담을 덱 선언
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			// 명령어를 담을 문자열
			String s = br.readLine();
			
			// 문자열이 명령어와 같은 지 비교
			// 큐에는 pop이 없으므로 poll 사용
			if(s.equals("pop")) {
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.pollLast());
			}
			else if(s.equals("size")) System.out.println(dq.size());
			// 데큐에는 empty말고 isEmpty() 사용
			else if(s.equals("empty")) {
				if(dq.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(s.equals("front")) {
				if(dq.isEmpty()) System.out.println(-1);
				else {
					System.out.println(dq.getLast());
				}
			}
			else if(s.equals("back")) {
				if(dq.isEmpty()) System.out.println(-1);
				else {
					System.out.println(dq.getFirst());
				}
			}
			// 문자열을 split으로 나눈 뒤 정수만 뽑아 사용
			else {
				String[] temp = s.split(" "); 
				dq.push(Integer.parseInt(temp[1]));
			}
		}
	}
	
}
