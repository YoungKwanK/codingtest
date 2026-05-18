class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 가격의 시점만큼 
        for(int i=0; i<prices.length; i++){
            if(i==prices.length-1) answer[i]=0;
            // 뒤에 주식 가격 떨어졌는 지 확인
            int time = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[i]>prices[j]) {
                    time++;
                    break;}
                else time++;
            }
            answer[i]=time;
        }
        return answer;
    }
}