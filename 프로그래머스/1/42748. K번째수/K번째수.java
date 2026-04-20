import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // commands의 수만큼 반복
        for(int l=0; l<commands.length; l++){
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            // 자른 값 저장
            int[] temp = new int[j-i+1];
            int num=0;
            for(int o=i-1; o<j; o++){
                temp[num]=array[o];
                num++;
            }
            Arrays.sort(temp);
            answer[l]=temp[k-1];
        }
        return answer;
    }
}