class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // [0]은 가로, [1]은 세로
        int[] minSizes = new int[2];
        
        int width = 0;
        int height = 0; 
        for(int i=0; i<sizes.length; i++){
            int temp=0;
            if(sizes[i][0]<sizes[i][1]){
                temp=sizes[i][1];
                sizes[i][1]=sizes[i][0];
                sizes[i][0]=temp;
            }
            width = Math.max(width,sizes[i][0]);
            height = Math.max(height,sizes[i][1]);
        }
        
        return width*height;
    }
}