import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주어진 수 N
        int N = sc.nextInt();

        // 소수의 개수를 담을 변수 선언
        int count =0;

        // 값을 저장할 배열 선언
        int[] arr = new int[N];

        // N만큼 자연수 받기
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
            boolean check = true;
            if(arr[i] == 1) check = false;
            // 소수 판별
            for(int j=2; j<arr[i]; j++) {
                if (arr[i] % j == 0) {
                    check=false;
                    break;
                }
            }
            if(check) {
                count++;
            }
        }
        System.out.println(count);
    }
}