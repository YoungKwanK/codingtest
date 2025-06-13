import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 명령 개수만큼 반복
        for(int i=0; i<commands.length; i++){
            // 자른 배열을 저장할 임시 배열 선언
            int[] temp = new int[commands[i][1]-commands[i][0]+1];
            // 자른 배열의 인덱스를 0부터 시작하기 위해
            int index=0;
            // 명령 수행
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                temp[index]=array[j];
                index++;
            }
            // 정렬
            Arrays.sort(temp);
            // k번째 값 저장
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}