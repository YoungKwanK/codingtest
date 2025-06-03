
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 카드 번호 받기
		int N = Integer.parseInt(br.readLine());
		
		// Deque 선언 및 초기화
		Deque<Integer> card = new ArrayDeque<>();
		
		// deque 뒤에 삽입 (순서가 위에서부터 1, 2 , 3... 이니까)
		for(int i=1; i<=N; i++) {
			card.addLast(i);
		}
		if(N==1) {
			System.out.println(1);
			return;
		}
		// 맨 위에 있는 거 하나 빼고 하나 뒤에 넣기
		while(card.size()>1) {
			card.removeFirst();
			if(card.size()==1) {
				System.out.println(card.getFirst());
				return;
			}
			int temp=card.getFirst();
			card.removeFirst();
			card.addLast(temp);
		}
	}
	
}
