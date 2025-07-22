import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = (long)n*(Arrays.stream(times).max()).getAsInt();
        long min = 0;
        while(min<=max){
            long mid = (min+max)/2;
            long count=0;
            for(int time : times){
                count+=mid/time;
            }
            if(count<n){
                min=mid+1;
            }else{
                max=mid-1;
                answer=mid;
            }
        }
        return answer;
    }
}