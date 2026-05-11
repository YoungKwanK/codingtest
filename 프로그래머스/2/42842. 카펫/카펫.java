import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown+yellow;
        
        for(int i=3; i<=Math.sqrt(sum); i++){
            if((sum/i-2) * (i-2) -yellow == 0){
                answer[1]=i;
                break;
            }
        }
        
        answer[0] = sum/answer[1];
        return answer;
    }
}