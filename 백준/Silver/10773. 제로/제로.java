
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받을 정수 개수 K
		int K = Integer.parseInt(br.readLine());
		
		
		// 입력받은 값을 저장할 스택선언
		Stack st = new Stack();
		
		// K만큼 반복
		for(int i=0; i<K; i++) {
			// 정수 하나씩 받기
			int temp = Integer.parseInt(br.readLine());
			
			// 만약 입력받은 정수가 0이 아니면 스택에 넣기
			if(temp!=0) st.add(temp);
			
			// 0일 시
			if(temp==0) {
				// 지금 스택이 비어있을 경우 다음 정수 받기
				if(st.isEmpty()) continue;
				// 안비어있으면 정수 빼기
				else st.pop();
			}
		}
		// 결과 저장하기
		int result=0;
		
		// 배열이 비어있으면 0 출력)
		if(st.isEmpty()) System.out.println(0);
		else {
			while(!st.isEmpty()) {
			result+=(int)st.pop();
			}
			System.out.println(result);
		}
		
	}
	
}
