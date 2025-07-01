import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        // bfs를 수행할 q
        Queue<int[]> q = new LinkedList<>();
        // 초깃값 세팅 - 문제와 다르게 시작점을 0,0으로 잡음
        q.add(new int[]{0,0,0});
        
        // bfs 수행
        while(!q.isEmpty()){
            int temp[] = q.poll();
            int x = temp[0];
            int y = temp[1];
            int distance = temp[2];
            // 목적지 도착
            if(x==maps.length-1 && y==maps[0].length-1){
                answer=distance+1;
                break;
            }
            // 이동
            for(int i=0; i<4; i++){
                int move_x=x+dx[i];
                int move_y=y+dy[i];
                // 맵을 벗어나는 경우 제외
                if(move_x<0 || move_y<0 || move_x>=maps.length || move_y>=maps[0].length){
                    continue;
                }
                // 가로막힌 벽과 이미 방문한 벽 제외
                else if(maps[move_x][move_y]==0){
                    continue;
                }else if(visited[move_x][move_y]){
                    continue;
                }else{
                    q.add(new int[]{move_x, move_y, distance+1});
                    visited[move_x][move_y]=true;
                }
            }
        }
        return answer;
    }
}