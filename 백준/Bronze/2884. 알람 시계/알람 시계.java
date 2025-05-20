import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        sc.close();

        if(M>=45){
            System.out.print(H + " ");
            System.out.print(M-45);
        }
        else{
            if(H>0){
                System.out.print(H-1 + " ");
                System.out.print(M+15);
            }
            else {
                System.out.print(23+" ");
                System.out.print(M+15);
            }
        }
    }
}