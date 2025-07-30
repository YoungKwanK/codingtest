import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            // 숫자 이어붙이기: N, NN, NNN...
            int concat = 0;
            for (int k = 0; k < i; k++) {
                concat = concat * 10 + N;
            }
            dp[i].add(concat);
        }

        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(b - a);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                        if (a != 0) dp[i].add(b / a);
                    }
                }
            }
            if (dp[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
