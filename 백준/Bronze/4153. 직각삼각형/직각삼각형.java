import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            if(A==0 && A==B && B==C){
                break;
            }

            if((C*C) == A*A+B*B){
                System.out.println("right");
            }
            else if(B*B == A*A+C*C){
                System.out.println("right");
            } else if (A*A == B*B+C*C){
                System.out.println("right");
            } else
                System.out.println("wrong");
        }
    }
}