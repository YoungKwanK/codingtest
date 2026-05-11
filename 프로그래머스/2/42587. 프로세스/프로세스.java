import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // [우선순위값, 인덱스]를 나타낼 큐
        Queue<int[]> q = new LinkedList<>();
        
        // 전체적 우선순위 확인하는 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);
        
        // 큐에 순차적으로 넣고 우선순위 큐에 따로 정렬
        for(int i=0; i<priorities.length; i++){
            q.add(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }
        
        // 위치를 찾을 때까지
        while(true){
            int max = pq.poll();
            System.out.println(max);
            int[] temp = q.poll();
            
            if(temp[0]!=max){ 
                q.add(temp);
                pq.add(max);
            }
            else{
                answer++;
                if(temp[1]==location) break;
            }
        } 
        return answer;
    }
}