
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 면적
        int N = Integer.parseInt(br.readLine());
        
        // (x, y) 좌표
        long[] x = new long[N];
        long[] y = new long[N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	x[i] = Integer.parseInt(st.nextToken());
        	y[i] = Integer.parseInt(st.nextToken());
        }
        
        // 신발끈 공식 -> 1/2(s1-s2)
        long s1 = 0;
        long s2 = 0;
        
        // s1, s2 구하기
        for(int i=0; i<N; i++) {
        	if(i==N-1) {
        		s1+=x[i]*y[0];
        		s2+=y[i]*x[0];
        		break;
        	}
        	s1 += x[i]*y[i+1];
        	s2 += y[i]*x[i+1];
        }
        double result = ((s1-s2)/2.0);
        if(result <0) System.out.printf("%.1f",result*(-1));
        else System.out.printf("%.1f",result);;
    }
}