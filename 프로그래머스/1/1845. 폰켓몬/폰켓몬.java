import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int half = nums.length/2;
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        if(s.size()<half) return s.size();
        else return half;
    }
}