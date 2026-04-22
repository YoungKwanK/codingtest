import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 최댓값을 알아내기 위해
        Arrays.sort(times);
        
        long left = 1; //최소
        long right = (long)times[times.length-1]*n; // 최대
        
        while(left<=right){
            long mid = (left+right)/2;
            long total = 0;
            
            // 시간이 주어졌을 때 총 면접 인원 수 구하기
            for(int time : times){
                total+=mid/time;
            }
            
            // n명 넘었을 때, 안넘었을 때 분기
            if(total >= n){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
}