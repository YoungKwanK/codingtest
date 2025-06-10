
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] ISBN = s.split("");
		
		int sumNum = 0;
		int index = 0;
		for(int i=0; i<ISBN.length; i++) {
			if(ISBN[i].equals("*")) {
				index = i;
				continue;
				}
			else if(i%2==0 || i==ISBN.length-1) sumNum+=Integer.parseInt(ISBN[i]);
			else sumNum+=3*Integer.parseInt(ISBN[i]);
		}
		int temp=0;
		for(int i=1; i<=9; i++) {
			if(index%2==0) {
				if((sumNum+i)%10==0) {
					temp=i;
					break;
				}
			}
			else {
				if((sumNum+i*3)%10==0) {
					temp=i;
					break;
				}
			}
		}
		System.out.println(temp);
		
	}
	
}
