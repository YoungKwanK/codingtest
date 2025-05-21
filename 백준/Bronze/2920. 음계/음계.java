import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[8];
        for(int i=0; i<8; i++){
            num[i] = sc.nextInt();
        }

        sc.close();

        String result = "";
        for(int i=1; i<8; i++){
            if(num[i] - num[i-1] == 1){
                result="ascending";
            }
            else if(num[i] - num[i-1] == -1){
                result="descending";
            }
            else {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);
    }
}