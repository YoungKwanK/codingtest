
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 명령어의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 명령어를 저장할 List 선언
		Set<String> set = new HashSet<>();
		
		// 1 ~ 20까지 담을 list
		Set<String> set2 = new HashSet<>();
		for(int i=1; i<=20; i++) {
			set2.add(String.valueOf(i));
		}
		
		// 시간 초과 방지를 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// 명령어의 개수만큼 반복
		for(int i=0; i<N; i++) {
			String[] command = br.readLine().split(" ");
			
			// 명령어의 종류에 따른 명령 수행
			if(command[0].equals("add")) {
				if(!set.contains(command[1])) set.add(command[1]);
			}
			else if(command[0].equals("remove")) {
				if(set.contains(command[1])) set.remove(command[1]);
				
			}
			else if(command[0].equals("check")) {
				if(set.contains(command[1])) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(command[0].equals("toggle")) {
				if(set.contains(command[1])) set.remove(command[1]);
				else set.add(command[1]);
			}
			else if(command[0].equals("all")) {
				set.clear();
				set.addAll(set2);
			}
			else if(command[0].equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb);
	}
	
}