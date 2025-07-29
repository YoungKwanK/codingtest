import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // lost배열과 reserve배열 중복제거를 위해 set에 저장
        Set<Integer> l = new HashSet<>();
        loop1:for(int temp : lost){
            for(int num : reserve){
                if(temp == num) continue loop1;
            }
            l.add(temp);
        }
        Set<Integer> r = new HashSet<>();
        loop2:for(int temp : reserve){
            for(int num : lost){
                if(temp == num) continue loop2;
            }
            r.add(temp);
        }
        
        // 빌려주기
        for(int temp : r){
            if(l.contains(temp-1)) l.remove(temp-1);
            else if(l.contains(temp+1)) l.remove(temp+1);
        }
        
        answer=n-l.size();
        
        return answer;
    }
}