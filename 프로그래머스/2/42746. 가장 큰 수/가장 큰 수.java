import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int 배열을 String 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. 두 수를 이어 붙였을 때 더 큰 순서로 정렬
        // (o2 + o1)과 (o1 + o2)를 비교하여 내림차순 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 3. 모든 숫자가 0인 경우 예외 처리
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        String answer="";
        for (String str : strNumbers) {
            answer+=str;
        }

        return answer;
    }
}