
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 N
		int N = Integer.parseInt(br.readLine());
		
		// 답을 담을 StringBuilder 선언
		StringBuilder answer = new StringBuilder();
		
		// 수열을 저장할 배열 선언
		int[] question = new int[N+1];
		
		// 수열 받기
		for(int i=1; i<N+1; i++) {
			question[i] = Integer.parseInt(br.readLine());
		}
		
		// 값을 넣을 스택 선언
		Stack<Integer> st = new Stack<>();
		
		// 수열을 만들 수 있는 지에 대한 boolean
		Boolean possible = true;
		
		// 현재 사용한 수 기록
		int count=1;
		
		// 오름차순으로 값 입력
		for(int i=1; i<=N; i++) {
			// 현재 스택의 값보다 수열이 더 클 때
			if(st.isEmpty() || st.peek()<question[i]) {
				if(count>question[i]) {
					possible = false;
					break;
				}
				while (count <= question[i]) {
					st.push(count++);
					answer.append("+\n");
				}
				st.pop();
				answer.append("-\n");
			}
			// 현재 스택보다 수열의 값이 작거나 같을 때
			else {
				// 현재 스택보다 수열의 값이 같을 때
				if(st.peek() == question[i]) {
					st.pop();
					answer.append("-").append("\n");
				}
				// 현재 스택보다 수열의 값이 작을 때
				else {
					possible = false;
					break;
				}
			}
			
		}
		if(possible)System.out.println(answer);
		else System.out.println("NO");

	}
	
}
