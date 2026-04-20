import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int food : scoville) {
            foods.add(food);
        }
        
        // 가장 작은 값이 K보다 작을 동안 반복
        while (foods.peek() < K) {
            // 섞으려면 최소 2개의 음식이 필요함
            if (foods.size() < 2) {
                return -1; 
            }
            
            int first = foods.poll();
            int second = foods.poll();
            
            // 섞기 공식 적용
            int mixed = first + (second * 2);
            foods.add(mixed);
            
            answer++; // 섞은 횟수 증가
        }
        
        return answer;
    }
}