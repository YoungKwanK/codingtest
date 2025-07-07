import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N
//		P1 IOI
//		P2 IOIOI
//		P3 IOIOIOI
//		PN IOIOI...OI (O가 N개)
		int N = Integer.parseInt(br.readLine());
		// 문자열 길이 M
		int M = Integer.parseInt(br.readLine());
		// 문자열을 받아 문자 배열로 변환
		char[] S = br.readLine().toCharArray(); 
		
		// 초기 P
		StringBuilder P = new StringBuilder("IOI");
		// N-1만큼 O와 I를 추가
		int answer=0;
		for(int i=0; i<N-1; i++) {
			P.append("O").append("I");
		}
		
		// 인덱스마다 있는 지 확인
		for(int i=0; i<S.length-P.length()+1; i++) {
			StringBuilder temp=new StringBuilder();
			for(int j=0; j<P.length(); j++) {
				temp.append(S[i+j]);
			}
			if(P.toString().equals(temp.toString())) answer++;
		}
		
		System.out.println(answer);
	}
}
