import java.util.*;
class Solution {
    static class Node{
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new Node(begin, 0));
        while(!q.isEmpty()){
            Node temp = q.poll();
            
            if(temp.word.equals(target)) return temp.count;
            
            for(int i=0; i<words.length; i++){
                if(visited[i]) continue;
                
                int w_count=0;
                for(int j=0; j<begin.length(); j++){
                    if(temp.word.charAt(j)!=words[i].charAt(j)) w_count++;
                }
                if(w_count==1){
                    q.add(new Node(words[i], temp.count+1));
                    visited[i]=true;
                }
            }
        }
        
        return answer;
    }
}