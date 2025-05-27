import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자연수 N과 K 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int N_mul=1;
        for(int i=1;i<=N;i++) {
            N_mul*=i;
        }
        
        int K_mul=1;
        for(int i=1;i<=K;i++) {
            K_mul*=i;
        }

        int N_K=1;
        for(int i=1;i<=N-K;i++) {
            N_K*=i;
        }
        if(N-K==0){
            N_K=1;
        }
        System.out.println(N_mul/K_mul/N_K);
    }
}