import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test case 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            
            // k층 n호
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            // 층과 호에 해당하는 2차원 배열 선언, 여기서 호는 1층부터이고 index는 0부터 시작이므로 +1
            int[][] apt = new int[k+1][n+1];

            // 각 층과 호에 대한 값 넣기
            for (int j = 0; j < k+1; j++) {
                for(int l = 1; l <= n; l++) {
                    if(j==0){
                        apt[j][l] = l;
                    }
                    else{
                        for(int m = 1; m <= l; m++) {
                            apt[j][l]+=apt[j-1][m];
                        }
                    }
                }
            }
            System.out.println(apt[k][n]);
        }
    }
}