import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2]; // 인덱스: 스테이지 번호 (1~N), N+1은 클리어한 사람
        for (int stage : stages) {
            stageCount[stage]++;
        }

        List<Stage> stageList = new ArrayList<>();
        int totalPlayers = stages.length;

        for (int i = 1; i <= N; i++) {
            int count = stageCount[i];
            double failureRate = totalPlayers == 0 ? 0 : (double) count / totalPlayers;
            stageList.add(new Stage(i, failureRate));
            totalPlayers -= count;
        }

        // 실패율 기준 내림차순 정렬, 같으면 스테이지 번호 오름차순
        stageList.sort((a, b) -> {
            if (b.rate == a.rate) {
                return Integer.compare(a.num, b.num);
            }
            return Double.compare(b.rate, a.rate);
        });

        // 결과 배열 추출
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).num;
        }

        return answer;
    }

    // 스테이지 정보 클래스
    static class Stage {
        int num;
        double rate;

        Stage(int num, double rate) {
            this.num = num;
            this.rate = rate;
        }
    }
}
