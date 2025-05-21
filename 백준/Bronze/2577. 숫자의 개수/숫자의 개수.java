import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] num_count = new int[10];

        String[] mul = String.valueOf(A*B*C).split("");

        for(int i=0; i<10; i++){
            for(int j=0; j< mul.length; j++){
                if(i==Integer.parseInt(mul[j])){
                    num_count[i]++;
                }
            }
            System.out.println(num_count[i]);
        }
    }
}