import java.util.*;

class Solution {
    // 중복 제거를 위한 Set
    Set<Integer> nums = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        String[] s = numbers.split("");
        boolean[] visited = new boolean[s.length];

        // DFS 시작 (빈 문자열에서 시작하여 모든 조합 생성)
        dfs("", s, visited);

        // Set에 담긴 모든 수에 대해 소수 판별
        for (int num : nums) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public void dfs(String current, String[] s, boolean[] visited) {
        // 현재까지 만들어진 문자열이 비어있지 않으면 숫자로 변환해 Set에 추가
        if (!current.equals("")) {
            nums.add(Integer.parseInt(current));
        }

        for (int i = 0; i < s.length; i++) {
            // 아직 방문하지 않은 숫자 카드라면
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                dfs(current + s[i], s, visited); // 숫자 이어 붙이기 (재귀)
                visited[i] = false; // 재귀가 끝나면 다음 조합을 위해 방문 해제 (백트래킹)
            }
        }
    }

    // 소수 판별 메서드
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}