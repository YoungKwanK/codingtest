import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }

        int max=num[0];
        int min=num[0];

        for(int i=1; i<N; i++){
            if(max<num[i])max=num[i];
            if(min>num[i])min=num[i];
        }
        System.out.print(min+" ");
        System.out.print(max);
    }
}