import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> people = new HashMap<>();

        // 참가자 카운트
        for (String p : participant) {
            people.put(p, people.getOrDefault(p, 0) + 1);
        }

        // 완주자 제거
        for (String c : completion) {
            people.put(c, people.get(c) - 1);
        }

        // 남은 한 명 찾기
        for (String key : people.keySet()) {
            if (people.get(key) > 0) {
                return key;
            }
        }
        return "";
    }
}
