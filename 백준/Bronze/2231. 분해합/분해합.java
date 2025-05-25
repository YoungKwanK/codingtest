import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = 0;

        // 생성자는 최대 N보다 작음
        for (int i = 1; i < N; i++) {
            int sum = i;
            int temp = i;

            // 각 자리수를 더함
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                result = i;
                break; // 가장 작은 생성자만 출력해야 하므로 break
            }
        }

        System.out.println(result);
    }
}
