
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 명령어의 수 N 받기
		int N = Integer.parseInt(br.readLine());
		
		// 값을 담을 스택 선언
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<N; i++) {
			// 명령어를 담을 문자열
			String s = br.readLine();
			
			// 문자열이 명령어와 같은 지 비교
			if(s.equals("pop")) {
				if(st.empty()) System.out.println(-1);
				else System.out.println(st.pop());
			}
			else if(s.equals("size")) System.out.println(st.size());
			else if(s.equals("empty")) {
				if(st.empty()) System.out.println(1);
				else System.out.println(0);
			}
			// top은 stack의 메서드에 없기에 pop으로 값을 뽑은 후 다시 같은 값을 push
			else if(s.equals("top")) {
				if(st.empty()) System.out.println(-1);
				else {
					int temp=0;
					temp=st.pop();
					st.push(temp);
					System.out.println(temp);
				}
			}
			// 문자열을 split으로 나눈 뒤 정수만 뽑아 사용
			else {
				String[] temp = s.split(" "); 
				st.push(Integer.parseInt(temp[1]));
			}
		}
	}
	
}
