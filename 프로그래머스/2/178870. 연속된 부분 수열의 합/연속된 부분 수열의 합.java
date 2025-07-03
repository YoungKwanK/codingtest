class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length-1};
        // 시작 인덱스
        int start=0;
        int end=0;
        int sum=sequence[0];
        // 시작 인덱스가 끝인덱스를 넘지 않도록 같은 건 허용
        while (start <= end && end < sequence.length){
            if(sum==k){
                // 길이가 짧은 수열 일 때
                if((answer[1]-answer[0])>end-start){
                    answer[0]=start;
                    answer[1]=end;
                    sum-=sequence[start];
                    start++;
                }else{
                    sum-=sequence[start];
                    start++;
                }
            }
            else if(sum<k){
                end++;
                if(end>=sequence.length) break;;
                sum+=sequence[end];
            }else{
                sum-=sequence[start];
                start++;
                
            }
        }
        return answer;
    }
}