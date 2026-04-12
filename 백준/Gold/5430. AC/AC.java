import java.util.*;
import java.io.*;
public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 개수 T
		int T = Integer.parseInt(br.readLine());
		
		loop:while(T-->0) {
//			명령어 받아 배열에 저장
			char[] command = br.readLine().toCharArray();
//			배열의 수
			int n = Integer.parseInt(br.readLine());
//			[x1,...,xn]과 같은 형태로 배열에 들어있는 정수
			List<Integer> answer = new ArrayList<>();
			String s = br.readLine();
			s = s.substring(1, s.length()-1);
			// 숫자만 뽑기
			if(!s.isEmpty()) {
				String[] temp = s.split(",");
				for(int i=0; i<temp.length; i++) {
					answer.add(Integer.parseInt(temp[i]));
				}
			}
			// p만큼 반복
			int R=0;
			for(int i=0; i<command.length; i++) {
				// D가 들어올 경우
				if(command[i]=='D') {
					// 리스트가 비여 있으면 error
					if(answer.size()==0) {
						System.out.println("error");
						continue loop;
					// 리스트가 있으면
					}else {
						// 정방향일 때 
						if(R%2==0) answer.remove(0);
						// 역방향일 때
						else answer.remove(answer.size()-1);
					}
				}
				// R이 들어올 경우
				else {
					R++;
				}
			}
			StringBuilder sb = new StringBuilder();
			if(answer.size()!=0) {
				if(R%2==0) {
					sb.append("[").append(answer.get(0));
					for(int j=1; j<answer.size(); j++) {
						sb.append(",").append(answer.get(j));
					}
					sb.append("]");
				}
				else {
					sb.append("[").append(answer.get(answer.size()-1));
					for(int j=1; j<answer.size(); j++) {
						sb.append(",").append(answer.get(answer.size()-1-j));
					}
					sb.append("]");
				}
			}
			else sb.append("[").append("]");
			System.out.println(sb);
		}
		
	}
}
