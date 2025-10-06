
import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char []notation = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		for(int i=0; i<notation.length; i++) {
			if(notation[i]>='A' && notation[i]<='Z') {
				sb.append(notation[i]);
			}else {
				if(notation[i]=='(') st.push('(');
				else if(notation[i]==')'){
					while(st.peek()!='(') {
						sb.append(st.pop());
					}
					st.pop();
				}
				else{
					if(st.isEmpty()) st.push(notation[i]);
					else if(notation[i]=='*' || notation[i]=='/') {
						if(st.peek()=='*' || st.peek()=='/') sb.append(st.pop());
						st.push(notation[i]);
					}
					else if(notation[i]=='+' || notation[i]=='-') {
						if(st.peek()!='(' && st.peek()!=')') {
							while(!st.isEmpty()) {
								if(st.peek()=='(') break;
								sb.append(st.pop());
							}
						}
						st.push(notation[i]);
					}
				}
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb);
		
	}
}