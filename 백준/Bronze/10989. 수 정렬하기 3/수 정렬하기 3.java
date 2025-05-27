import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자의 개수
        int N = Integer.parseInt(br.readLine());

        //숫자들의 빈도수를 저장할 배열 선언 어차피 수는 10,000보다 작거나 같은 자연수
        int[] nums= new int[10001];
        
        // 주어진 수에 해당하는 인덱스에 +1를 더함
        for(int i=0; i<N; i++){
            nums[Integer.parseInt(br.readLine())]++;
        }
        br.close();
        
        // 출력
        // 시간 초과 방지를 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i=1; i< 10001; i++){
            // 값을 있다면(값을 입력받았다면)
            while(nums[i] > 0){
                sb.append(i).append("\n");
                nums[i]--;
            }
        }
        System.out.print(sb);
    }
}