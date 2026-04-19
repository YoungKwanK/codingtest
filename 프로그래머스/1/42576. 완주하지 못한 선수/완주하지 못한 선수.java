import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // Hashmap에 넣기
        Map<String, Integer> people = new HashMap<>();
        for(String p : participant){
            people.put(p, people.getOrDefault(p,0)+1);
        }
        
        // HashMap에서 빼기
        for(String p : completion){
            int count=people.get(p);
            if(count==1) people.remove(p);
            else{
                people.put(p,count-1);
            }
        }
        
        // 정답 저장
        for(String p : people.keySet()){
            answer+=p;
        }
        return answer;
    }
}