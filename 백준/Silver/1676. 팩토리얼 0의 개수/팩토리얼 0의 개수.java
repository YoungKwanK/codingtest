import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 N
        int N = Integer.parseInt(br.readLine());

        int count=0;

        for (int i = 5; i <= N; i*=5) {
            count+=N/i;
        }
        System.out.println(count);
    }
}
