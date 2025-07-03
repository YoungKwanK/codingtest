class Solution {
    public int solution(int n) {
        int answer = 0;
        int start=1;
        int end=1;
        int sum=1;
        while(start<=end && end<=n){
            if(sum==n){
                answer++;
                end++;
                sum+=end;
            }
            else if(sum>n){
                sum-=start;
                start++;
            }
            else if(sum<n){
                end++;
                sum+=end;
            }
        }
        return answer;
    }
}