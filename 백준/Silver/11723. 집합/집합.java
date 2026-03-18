
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	// 공집합 S 설정
    	Set<Integer> S = new HashSet<>();
    	
    	// 연산의 수 M
    	int M = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	
    	// 연산의 수만큼 반복
    	for(int i=0; i<M; i++) {
    		//연산 받기
    		st = new StringTokenizer(br.readLine());
    		
			// 연산의 명령어 받기
			String command = st.nextToken();
			
			// 명령어 필터링
			if(command.equals("add")) {
				S.add(Integer.parseInt(st.nextToken()));
			}
			else if(command.equals("remove")) {
				S.remove(Integer.parseInt(st.nextToken()));
			}
			else if(command.equals("check")) {
				if(S.contains(Integer.parseInt(st.nextToken()))){
					sb.append('1').append('\n');
				}
				else sb.append('0').append('\n');;
			}
			else if(command.equals("toggle")) {
				boolean check=false;
				int num2 = Integer.parseInt(st.nextToken());
				for(int num : S) {
					if(num == num2) {
						S.remove(num);
						check = true;
						break;
					}
				}
				if(!check) S.add(num2);
			}
			else if(command.equals("all")) {
				Set<Integer> temp = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

				S.addAll(temp);
			}
			else {
				S.clear();
			}
    	}
    	System.out.println(sb);
    }
}