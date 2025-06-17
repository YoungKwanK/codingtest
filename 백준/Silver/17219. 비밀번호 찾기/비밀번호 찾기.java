import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사이트의 갯수 N, 찾을 사이트의 갯수 M 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 사이트와 비밀번호를 저장할 map 선언
		Map<String, String> site = new HashMap<>();
		
		// 사이트의 갯수만큼 입력받기
		for(int i=0; i<N; i++) {
			// 사이트와 비밀번호를 한 줄로 받고 분리
			st = new StringTokenizer(br.readLine());
			site.put(st.nextToken(), st.nextToken());
		}
		
		// 찾으려는 비밀번호 수만큼 반복
		for(int i=0; i<M; i++) {
			String siteName = br.readLine();
			System.out.println(site.get(siteName));
		}
	}	
	
}
