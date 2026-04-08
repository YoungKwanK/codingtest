
import java.util.*;
import java.io.*;

public class Main {
	static int count=0;
	static int result=0;
	static int N, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, r, c
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        rc(0,0,(int)Math.pow(2,N));
        System.out.println(count);
    }
    
    static void rc(int x, int y, int n) {
    	if(n==1) {
    		result=count;

    	}
    	else{
    		if(r<x+n/2 && c<y+n/2) rc(x, y, n/2);
    		else if(r<x+n/2 && c>=y+n/2) {
    			count+=n/2 * n/2;
    			rc(x, y+n/2, n/2);
    		}
    		else if(r>=x+n/2 && c<y+n/2) {
    			count+=n/2*n/2*2;
    			rc(x+n/2, y, n/2);
    		}
    		else {
    			count+=n/2*n/2*3;
    			rc(x+n/2, y+n/2, n/2);
    		}
    	}
    }
}