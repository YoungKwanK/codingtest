import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 단어의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 단어를 저장할 set 선언
        Set<String> s = new HashSet<>();
        
        for(int i=0; i<N; i++){
            s.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(s);
        
        list.sort((o1, o2)-> {
           if(o1.length()!=o2.length()){
               return o1.length()-o2.length();
           } 
           else{
               return o1.compareTo(o2);
           }
        });
        
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
	}
	
}
