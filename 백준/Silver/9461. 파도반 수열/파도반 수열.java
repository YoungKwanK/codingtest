

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        //테이블 정의
        // 1<=n<=100 이므로
        long[] result= new long[101];
        
        // 초기값
        result[1]=1;
        result[2]=1;
        result[3]=1;
        result[4]=2;
        result[5]=2;
        for(int i=6; i<result.length; i++) {
        	result[i]=result[i-5]+result[i-1];
        }
        // 테스트 케이스만큼 반복
        for(int i=0; i<T; i++) {
        	// N이 주어졌을 때
        	int N = Integer.parseInt(br.readLine());
        	System.out.println(result[N]);
        }
    }
}
