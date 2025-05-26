import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String N = br.readLine();
            if(N.charAt(0) == '0') return;
            String[] number = N.split("");
            String result = "yes";
            for(int i = 0; i < number.length/2; i++){
                if(number.length==1) break;
                if(Integer.parseInt(number[i])!=Integer.parseInt(number[number.length-i-1])){
                    result="no";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}