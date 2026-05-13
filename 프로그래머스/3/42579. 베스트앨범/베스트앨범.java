import java.util.*;
class Solution {
    
    static class Song{
        int num;
        int count;
        
        Song(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 장르의 총 재생 수 비교
        Map<String, Integer> m = new HashMap<>();
        Map<String, List<Song>> s = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            m.put(genres[i], m.getOrDefault(genres[i], 0)+plays[i]);
            
            if(!s.containsKey(genres[i])) s.put(genres[i], new ArrayList<>());
            s.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> sort_song = new ArrayList<>(m.keySet());
        sort_song.sort((o1, o2) -> m.get(o2)-m.get(o1));
        
        // 장르 내 많이 재생된 노래 수록하기
        
        for(int i=0; i<sort_song.size(); i++){
            List<Song> temp = new ArrayList<>();
            for(int j=0; j<s.get(sort_song.get(i)).size(); j++){
                temp.add(s.get(sort_song.get(i)).get(j));
            }
            
            temp.sort((o1, o2) -> o2.count-o1.count);
            
            int stop = 0;
            for(int j=0; j<temp.size(); j++){
                answer.add(temp.get(j).num);
                stop++;
                if(stop==2) break;
            }
        }
        return answer;
    }
}