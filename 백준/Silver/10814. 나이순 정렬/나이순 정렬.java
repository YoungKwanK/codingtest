
import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력받을 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 나이와 이름을 저장할 배열 리스트 만들기
		ArrayList[] people = new ArrayList[100001];
		for(int i=1; i<people.length; i++) {
			people[i]=new ArrayList<>();
		}
		
		StringTokenizer st;
		
		// 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[age].add(name);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 출력
		for(int i=0; i<10001; i++) {
			if(people[i]!=null) {
				for(int j=0; j<people[i].size(); j++) {
					sb.append(i+" ").append(people[i].get(j)).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
}
