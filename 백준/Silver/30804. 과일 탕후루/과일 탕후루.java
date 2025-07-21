
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 과일의 개수 N 
		int N = Integer.parseInt(br.readLine());
		
		// 과일 받기
		st = new StringTokenizer(br.readLine());
		int[] fruits = new int[N];
		for(int i=0; i<N; i++) {
			fruits[i]=Integer.parseInt(st.nextToken());
		}
		// 과일의 종류를 담을 map
		Map<Integer, Integer> fruit = new HashMap<>();
		
		// 투 포인터
		int left=0;
		int right=0;
		// 가장 많은 과일의 개수
		int count=0;
		int answer=1;
		
		while(left<=right && right<N) {
			fruit.put(fruits[right], fruit.getOrDefault(fruits[right],0)+1);
			right++;
			count++;
			if(fruit.size()<=2) {
				answer=Math.max(answer, count);
			}else {
				while(fruit.size()>2) {
					fruit.put(fruits[left], fruit.get(fruits[left])-1);
					if(fruit.get(fruits[left])==0) fruit.remove(fruits[left]);
					left++;
					count--;
				}
				
			}
		}
		System.out.println(answer);
	}
}