import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자연수 N 받기
        int N =Integer.parseInt(br.readLine());
        br.close();

        int result=0;

        // 1 ~ N 자리수 더하기
        for(int i=2; i<N; i++) {
            int sum = i;
            //자리수 값 구하기
            for (int j=i; j>0; j=j/10) {
                sum+=j%10;
            }
            if(sum==N){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
}