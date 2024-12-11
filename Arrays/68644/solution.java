import java.util.HashSet;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        //모든 더했을 때의 경우의 수 구하기
        HashSet<Integer> all_case = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                all_case.add(numbers[i]+numbers[j]);
            }
        }
        
        //정렬 후 배열 형태로 변환
        answer = all_case.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
