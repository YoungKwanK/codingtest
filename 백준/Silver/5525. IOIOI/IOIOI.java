
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // IOI가 N개 반복
        int M = Integer.parseInt(br.readLine()); // 문자열 길이
        String S = br.readLine(); // 문자열

        int answer = 0;
        int count = 0;

        for (int i = 1; i < M - 1; ) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;
                if (count == N) {
                    answer++;
                    count--; // 겹치는 경우를 위해 1 줄임 (앞의 I를 다시 활용)
                }
                i += 2;
            } else {
                count = 0; // 끊기면 초기화
                i++;
            }
        }

        System.out.println(answer);
    }
}