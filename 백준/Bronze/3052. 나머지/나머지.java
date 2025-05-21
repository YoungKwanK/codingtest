import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 나머지 값을 저장할 배열 선언
        boolean[] num = new boolean[42];

        // 나머지 값을 구하고 해당 인덱스에 true
        for(int i = 0; i < 10; i++){
            num[sc.nextInt()%42] = true;
        }

        // true가 나온 횟수 더하기
        int count=0;
        for(int i = 0; i < 42; i++){
            if(num[i]==true){
                count++;
            }
        }
        System.out.println(count);
    }
}