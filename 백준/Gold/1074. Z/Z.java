import java.util.*;
import java.io.*;
public class Main{
	static int count=0;
	static int result=0;
	static int N, r, c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//   N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2,N);
		
		cal(0, 0, size);
		
		System.out.println(result);
	}
	static void cal(int x, int y, int size) {
		if(size==1) {
			result = count;
		}
		else {
			int half = size/2;
			// 1사분면
			if(r<x+half && c< y+half) {
				cal(x, y, half);
			// 2사분면
			}else if(r<x+half && c>=y+half) {
				count+=half*half;
				cal(x, y+half, half);
			// 3사분면
			} else if(r>=x+half && c<y+half) {
				count+=2*half*half;
				cal(x+half, y, half);
			// 4사분면
			}else {
				count+=3*half*half;
				cal(x+half, y+half, half);
			}
		}
	}
}
