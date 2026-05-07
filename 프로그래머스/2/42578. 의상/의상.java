import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 자료형 선언 <종류, 갯수>
        Map<String, Integer> kinds = new HashMap<>();
        
        for(String[] cloth : clothes){
            kinds.put(cloth[1], kinds.getOrDefault(cloth[1], 0)+1);
        }
        
        for(String cloth : kinds.keySet()){
            answer*=(kinds.get(cloth)+1);
        }
        return answer-1;
    }
}