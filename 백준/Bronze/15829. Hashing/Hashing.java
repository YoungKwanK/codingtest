import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final int r = 31;
        final int M = 1234567891;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;
        long power = 1;

        for (int i = 0; i < L; i++) {
            int val = str.charAt(i) - 'a' + 1;
            sum = (sum + val * power) % M;
            power = (power * r) % M;
        }

        System.out.println(sum);
    }
}
