import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 전체 사람의 수 N 받기
        int N = Integer.parseInt(br.readLine());
        
        // 키와 몸무게를 저장할 배열 선언
        int[] x = new int[N];
        int[] y = new int[N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	x[i]=Integer.parseInt(st.nextToken());
        	y[i]=Integer.parseInt(st.nextToken());
        }
        br.close();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	int count=1;
        	for(int j=0; j<N; j++) {
        		if(x[i]<x[j] && y[i]<y[j]) {
        			count++;
        		}
        	}
        	sb.append(count+" ");
        }
        System.out.print(sb);
    }
}