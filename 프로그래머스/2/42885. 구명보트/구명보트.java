import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 1. 오름차순 정렬
        Arrays.sort(people);
        
        // 2. 가장 가벼운 사람(left)과 가장 무거운 사람(right) 가리키기
        int left = 0;
        int right = people.length - 1;
        
        // 3. 두 포인터가 만날 때까지 반복
        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람의 합이 limit 이하일 때만 가벼운 사람을 태움
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            // 무거운 사람은 (같이 타든 혼자 타든) 무조건 이번 보트에 태워 보냄
            right--;
            
            // 보트 수 증가
            answer++;
        }
        
        return answer;
    }
}