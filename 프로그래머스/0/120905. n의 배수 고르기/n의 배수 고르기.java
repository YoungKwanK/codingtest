import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<numlist.length; i++){
            if(numlist[i]%n==0 && numlist[i]!=0){
                li.add(numlist[i]);
            }
        }  
        int[] answer = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            answer[i]=li.get(i);
        }
        return answer;
    }
}