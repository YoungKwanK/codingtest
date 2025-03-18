import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> num = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            num.add(nums[i]);
        }
        if(num.size()>nums.length/2)
            answer=nums.length/2;
        else
            answer=num.size();
        return answer;
    }
}