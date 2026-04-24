import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int start = 0;
        int temp = 0; 
        
        while(start < progresses.length){
            for(int i = start; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            
            if(progresses[start] >= 100){
                for(int i = start; i < progresses.length; i++){
                    if(progresses[i] >= 100){
                        temp++;
                        start++;
                    } else {
                        break; 
                    }
                }
                if(temp > 0) {
                    answer.add(temp);
                    temp = 0;
                }
            }
        }
        return answer;
    }
}