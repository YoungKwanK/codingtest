import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 참가자 수 N
        int N = sc.nextInt();

        // 티셔츠 사이즈별 신청자의 수를 저장할 배열
        int[] size= new int[6];
        // 신청자 수 받기
        for(int i = 0; i < 6; i++) {
            size[i]= sc.nextInt();
        }

        // 정수 티셔츠와 펜의 묶음 수를 의미하는 정수 T와 P
        int T = sc.nextInt();
        int P = sc.nextInt();

        // 티셔츠 최소 묶음 수 구하기
        int T_count=0;
        for(int i=0;i<size.length;i++){
            if(size[i]%T==0){
                T_count+=size[i]/T;
            }
            else T_count+=size[i]/T+1;
        }

        // 펜 최대 묶음 수와 한 자루씩 주문
        int p_count1, p_count2 = 0;
        p_count1=N/P;
        p_count2=N%P;

        System.out.printf("%d \n%d %d",T_count,p_count1,p_count2);
    }
}