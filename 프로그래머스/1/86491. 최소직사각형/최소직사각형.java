class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 초깃값 세팅
        int maxX=0;
        int maxY=0;
        int temp;
        
        // 명함 사이즈들 정렬
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]>sizes[i][1]){
                temp = sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
            maxX = Math.max(maxX, sizes[i][0]);
            maxY = Math.max(maxY, sizes[i][1]);
        }
        answer = maxX * maxY;
        return answer;
    }
}