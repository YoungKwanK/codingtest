import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열 L 입력
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st1.nextToken());

        // 문자열 입력
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String st2String = st2.nextToken();
        char[] stringArr = new char[L];
        for(int i=0; i<L; i++) {
            stringArr[i] = st2String.charAt(i);
        }

        //
        int sum=0;
        for(int i=0; i<L; i++) {
            for(int j=1; j<=26; j++) {
                if(stringArr[i]=='a'+j-1) {
                    sum=(int)(sum+j*Math.pow(31, i));
                }
            }
        }
        System.out.println(sum);
    }
}