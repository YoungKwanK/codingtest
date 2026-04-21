import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> s = new HashSet<>();
        for (int l : lost) s.add(l);

        // 자기꺼 먼저 
        List<Integer> l = new ArrayList<>();
        for (int r : reserve) {
            if (s.contains(r)) {
                s.remove(r); 
            } else {
                l.add(r);    
            }
        }

        // 빌려주기
        for (int r : l) {
            if (s.contains(r - 1)) {
                s.remove(r - 1);
            } else if (s.contains(r + 1)) {
                s.remove(r + 1);
            }
        }

        return n - s.size();
    }
}