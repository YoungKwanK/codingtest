import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 개수 N 받기
		int N = Integer.parseInt(br.readLine());
		
		// 정수를 담을 배열 선언
		int[] nums = new int[N];
		
		// 정수 받기
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		// 평균 구하기
		int sum=0;
		for(int i=0; i<N; i++) {
			sum+=nums[i];
		}
		System.out.println(Math.round((double)sum/N));
		
		// 중앙값 구하기
		Arrays.sort(nums);
		System.out.println(nums[N/2]);
		
		// 최빈값 구하기
		Map<Integer, Integer> frequence = new HashMap<>();
		for(int num : nums) {
			frequence.put(num, frequence.getOrDefault(num, 0)+1);
		}
		int max = -1;
		int temp=0;
		for(int num : frequence.keySet()) {
			if(frequence.get(num)>=max) { 
				max=frequence.get(num);
				temp=num;
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int num : frequence.keySet()) {
			if(frequence.get(temp)== frequence.get(num)) { 
				list.add(num);
			}
		}
		Collections.sort(list);
		if(list.size()==1) {
			System.out.println(list.get(0));
		}
		else
			System.out.println(list.get(1));
		
		// 범위 구하기
		if(nums.length==1) {
			System.out.println(0);
		}
		else {
			System.out.println(nums[nums.length-1]-nums[0]);
			
		}
	}
}
