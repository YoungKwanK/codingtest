import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, K 받기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// ArrayList 선언
		List<Integer> circle = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			circle.add(i);
		}
		
		// 출력할 문자열 선언
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int temp = K - 1;
		while (!circle.isEmpty()) {
			temp = temp % circle.size();
			sb.append(circle.get(temp));
			circle.remove(temp);
			
			if (!circle.isEmpty()) {
				sb.append(", ");
				temp += K - 1;
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
