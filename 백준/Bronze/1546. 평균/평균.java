import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과목의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 세준이의 현재 성적 받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double[] scores = new double[N];
        double M=0;
        for(int i=0;i<N;i++){
            scores[i] = Integer.parseInt(st.nextToken());
            // 값을 받으면서 최댓값 저장
            if(scores[i]>M) M=scores[i];
        }

        // 점수/M*100으로 고치고 총합 구하기
        double sum=0;
        for(int i=0;i<N;i++){
            scores[i]=scores[i]/M*100;
            sum+=scores[i];
        }
        
        //평균 구하기
        System.out.println(sum/N);
    }
}