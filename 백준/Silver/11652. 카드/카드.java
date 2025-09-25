
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 숫자 카드를 저장할 List 선언
		Map<Long, Integer> cards = new HashMap<>();
		
		// N만큼 받기
		// 숫자 크기의 범위가 크기 때문에 Long 사용
		for(int i = 0; i<N; i++) {
			Long card = Long.parseLong(br.readLine()); 
			cards.put(card, cards.getOrDefault(card,0)+1);
		}
		List<Long> cards_key = new ArrayList<>(cards.keySet());
		Collections.sort(cards_key, (a1, a2)->{
			if(!cards.get(a2).equals(cards.get(a1)))
				return cards.get(a2)-cards.get(a1);
			return a1.compareTo(a2);
		});
		
		System.out.println(cards_key.get(0));
	}
}