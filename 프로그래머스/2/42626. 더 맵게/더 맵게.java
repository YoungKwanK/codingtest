import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐 선언
        Queue<Integer> pq = new PriorityQueue<>();
        // 큐에 음식 넣기
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        // 만들 지 못할 경우를 처리할 boolean
        boolean possible = true;
        // 제일 작은 스코빌 지수가 K이상이 될때까지 반복
        while(pq.peek()<K){
            if(pq.size()<2){
                possible = false;
                break;
            }
            else{
                int min1 = pq.poll();
                int min2 = pq.poll();
                pq.add(min1+min2*2);
                answer++;
            }
        }
        if(!possible) answer=-1;
        return answer;
    }
}