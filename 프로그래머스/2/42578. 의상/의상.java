import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<>();
        // Map에 의상 종류에 따른 개수 넣기
        for(int i=0; i<clothes.length; i++){
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
        }
        for(String cloth : clothesMap.keySet()){
            answer*=(clothesMap.get(cloth)+1);
        };
        
        return answer-1;
    }
}