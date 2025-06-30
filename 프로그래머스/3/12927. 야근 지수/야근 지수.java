import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int a : works){
            pq.add(a);
        }
        for(int i=n; i>0; i--){
            int temp=pq.poll();
            if(temp==0){
                pq.add(temp);
                continue;
            }
            temp=temp-1;
            pq.add(temp);
        }
        long answer = 0;
        while(!pq.isEmpty()){
            int temp=pq.poll();
            answer+=temp*temp;
        }
        return answer;
    }
}