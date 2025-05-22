import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 단어 받기
        String S = sc.next();
        
        // 알파벳 개수만큼 저장
        int[] arr = new int[26];
        // 모든 인덱스의 값을 -1로 설정
        Arrays.fill(arr, -1);


        for(int i = 0; i < S.length(); i++){
            for(int j = 0; j<arr.length; j++){
                // 만약 인덱스의 값이 -1이면 (처음 나오는 알파벳이면) 위치 저장
                if(arr[j]==-1){
                    // 아스키 코드를 활용하여 단어의 위치를 저장
                    if (S.charAt(i)==(char)('a'+j))
                        arr[j]=i;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}