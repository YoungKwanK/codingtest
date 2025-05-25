import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드의 개수 N과 M 받기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        // 카드에 쓰여 있는 수 받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st2.nextToken());
        }

        int result = 0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    if (M-card[i]-card[j]-card[k]>=0 && result<card[i]+card[j]+card[k]){
                        result=card[i]+card[j]+card[k];
                    }
                }
            }
        }
        System.out.println(result);
    }
}