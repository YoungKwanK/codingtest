
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1; // 연산 횟수에 1을 더한 값을 출력해야 하므로 1부터 시작

        while (B != A) {
            if (B < A) { // B가 A보다 작아지면 만들 수 없음
                System.out.println(-1);
                return;
            }

            if (B % 10 == 1) { // 1. 끝자리가 1인 경우
                B /= 10;
            } else if (B % 2 == 0) { // 2. 짝수인 경우
                B /= 2;
            } else { // 3. 그 외의 경우 (약수가 없거나 끝이 1이 아님)
                System.out.println(-1);
                return;
            }
            
            count++;
        }

        System.out.println(count);
    }
}