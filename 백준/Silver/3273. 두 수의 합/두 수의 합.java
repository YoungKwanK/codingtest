
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수열의 크기 n
		int n = Integer.parseInt(br.readLine());
		
		// 수열에 포함되는 수
		st = new StringTokenizer(br.readLine(), " ");
		List<Integer> nums = new ArrayList<>();
		while(st.hasMoreTokens()) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		// 목표 x
		int x = Integer.parseInt(br.readLine());
		
		// 정렬
		nums.sort((o1,o2)-> o1-o2);
		
		// 투포인터
		int start = 0;
		int end = n-1;
		int answer = 0;
		
		while(start<end) {
			if(nums.get(start)+nums.get(end)==x) {
				answer++;
				end--;
			}
			else if(nums.get(start)+nums.get(end)<x) {
				start++;
			}
			else {
				end--;
			}
		}
		System.out.println(answer);
	}
}