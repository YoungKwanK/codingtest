class Solution {
    
    static boolean[] visited;
    int answer =0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int index){
        answer = Math.max(answer, index);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; 
                dfs(k - dungeons[i][1], dungeons, index + 1);
                visited[i] = false; 
            }
        }
    }
}