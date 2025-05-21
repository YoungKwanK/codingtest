import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //테스트케이스 수
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            // 반복횟수 R, 문자열 S
            int R = sc.nextInt();
            String S = sc.next();

            // 새 문자열 P
            String P ="";
            
            // 문자열 분리
            String[] StoChar = S.split("");
            for(int j=0; j<StoChar.length; j++){
                for(int k=0; k<R; k++){
                    P+=StoChar[j];
                }
            }
            System.out.println(P);
        }
    }
}