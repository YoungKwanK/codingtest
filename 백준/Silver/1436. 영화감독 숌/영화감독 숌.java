import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 N
        int N=Integer.parseInt(br.readLine());
        int num = 666;

        int count=0;
        while(true){
            if(String.valueOf(num).contains("666")){
                count++;
            }
            if(count==N){
                System.out.println(num);
                return;
            }
            num++;
        }
    }
}