import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	// A를 B번 곱해서 C로 나누기
    	long A = Long.parseLong(st.nextToken());
    	long B = Long.parseLong(st.nextToken());
    	long C = Long.parseLong(st.nextToken());
    	
    	System.out.println(pow(A,B,C));
    }
    public static long pow(long a, long b, long c) {
    	if(b==1) {
    		return a%c;
    	}
    	
    	long temp = pow(a, b/2, c);
    	
    	if(b%2 ==0) {
    		return temp*temp%c;
    	}else {
    		return (temp*temp%c) * (a%c) % c;
    	}
    }
}