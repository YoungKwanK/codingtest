import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> people = new HashMap<>();
        String answer = null;

        // 참가자(동명이인이 있을 경우 value+1)
        for (String p : participant) {
            people.put(p, people.getOrDefault(p, 0) + 1);
        }

        // 완주자 제거 (완주하면 그 이름을 가진 사람 수 -1)
        for (String c : completion) {
            people.put(c, people.get(c) - 1);
        }

        // 완주하지 못한 사람 
        for (String key : people.keySet()) {
            if (people.get(key) > 0) {
                answer= key;
            }
        }
        return answer;
    }
}
