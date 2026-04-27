class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 삼각형의 높이만큼 맨 밑 -1 에서부터
        for(int i=triangle.length-1; i>0; i--){
            // 해당 지점으로 가는 두 개의 경우에 대해
            for(int j=0; j<triangle[i].length-1; j++){
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}