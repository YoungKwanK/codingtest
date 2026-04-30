import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 오름차순 (최솟값 추출용)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        // 내림차순 (최댓값 추출용)
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");
            int value = Integer.parseInt(op[1]);

            if (op[0].equals("I")) {
                minPq.add(value);
                maxPq.add(value);
            } else if (!minPq.isEmpty()) {
                if (value == 1) {
                    // 최댓값 삭제: maxPq에서 빼고, minPq에서도 동기화
                    int max = maxPq.poll();
                    minPq.remove(max);
                } else {
                    // 최솟값 삭제: minPq에서 빼고, maxPq에서도 동기화
                    int min = minPq.poll();
                    maxPq.remove(min);
                }
            }
        }

        if (minPq.isEmpty()) {
            return new int[]{0, 0};
        } else {
            // maxPq의 첫 번째가 최댓값, minPq의 첫 번째가 최솟값
            return new int[]{maxPq.peek(), minPq.peek()};
        }
    }
}