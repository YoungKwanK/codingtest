
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 T 받기
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스만큼 반복
		for(int i=0; i<T; i++) {
			// 한 문장을 담을 임시 문장 추가
			String temp = br.readLine();
			
			// 괄호를 처리할 stack 추가
			Stack st = new Stack();
			
			// 한 단어씩 처리
			for(int j=0; j<temp.length(); j++) {
				// ( 이면 추가
				if(temp.charAt(j)=='(') {
					st.add('(');
				}
				// )일 때
				else if(temp.charAt(j)==')') {
					// 스택이 비어있을 때 NO 출력하고 다음 문장으로 넘기기
					if(st.isEmpty()) {
						st.add('N');
						break;
					}
					// 스택이 있을 경우('('가 있을 경우) 스택 비우기
					else st.pop();
				}
			}
			// 스택이 비어있을 경우(짝을 다 맞췄을 경우)
			if(st.isEmpty()) {
				System.out.println("YES");
			}
			// 스택이 채워져 있을 경우(짝이 안맞을 경우)
			else System.out.println("NO");
		}
		br.close();
	}
	
}
