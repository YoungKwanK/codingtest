import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n+1];
        a[0]=1;
        a[1]=3;
        if(n==1){
            System.out.println(a[0]);
        }
        else if(n==2){
            System.out.println(a[1]);
        }
        else{
            for(int i=2; i<n; i++){
                a[i]=(a[i-1]+2*(a[i-2]))%10007;
            }
            System.out.println(a[n-1]);
        }
    }
}