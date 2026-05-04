class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0; // 탐색을 시작할 위치
        
        // 최종적으로 만들어야 할 숫자의 길이는 (전체 길이 - k)
        int targetLength = number.length() - k;

        // 뽑아야 할 개수만큼 반복
        for (int i = 0; i < targetLength; i++) {
            char max = '0';
            
            // k+i 범위까지 확인하는 이유: 
            // 뒤에 뽑아야 할 숫자들(targetLength - 1 - i)을 위한 자리를 남겨두기 위함
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1; // 가장 큰 숫자를 찾은 바로 다음 인덱스부터 다시 탐색
                }
                
                // 만약 '9'를 찾았다면 더 이상 뒤를 볼 필요가 없음 (최적화)
                if (max == '9') break;
            }
            sb.append(max);
        }

        return sb.toString();
    }
}