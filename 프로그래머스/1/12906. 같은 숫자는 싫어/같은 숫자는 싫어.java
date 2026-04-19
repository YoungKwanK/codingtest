import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        // 값을 저장할 리스트
        // List<Integer> nums = new ArrayList<>();
        int lastnum = arr[0];
        answer.add(lastnum);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==lastnum) continue;
            else{
                lastnum=arr[i];
                answer.add(lastnum);
            }
        }
        
//         for(int num : nums){
            
//         }
        

        return answer;
    }
}