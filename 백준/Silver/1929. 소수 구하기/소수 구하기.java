import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// M과 N 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// M부터 N까지 반복문
		for(int i=M; i<=N; i++) {
			// 기본값 true
			boolean check = true;
			if(i==1) check=false;
			// 나누어지는 값이 있으면
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					check=false;
					break;
				}
			}
			if(check==true)System.out.println(i);
		}
	}
	
}
