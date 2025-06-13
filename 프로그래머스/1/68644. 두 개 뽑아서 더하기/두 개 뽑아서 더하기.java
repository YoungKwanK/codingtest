import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
class Solution{
	public static int[] solution(int[] numbers){
		Set<Integer> set = new HashSet<>();   //중복값 제거를 위한 해시셋 생성
		//두 수를 선택하는 모든 경우의 수를 반복문으로 구함
		for(int i = 0; i < numbers.length - 1; i++){
			for(int j = i + 1; j < numbers.length; j++){
				//두 수를 더한 결과를 해시셋에 추가
				set.add(numbers[i] + numbers[j]);
			}
		}
        // 정답을 저장할 배열 선언
        int[] answer = new int[set.size()];
        int index=0;
		//해시셋의 값을 뽑아 정답 배열에 저장
        for(int num : set){
            answer[index]=num;
            index++;
        }
        // 정답 배열을 오름차순 정렬
        Arrays.sort(answer);
		return answer;
	}
}