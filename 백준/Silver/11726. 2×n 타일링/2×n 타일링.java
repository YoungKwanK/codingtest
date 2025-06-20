import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n+2];
        a[0]=0;
        a[1]=1;
        a[2]=2;
        if(n==1){System.out.println(a[1]);}
        else if(n==2){System.out.println(a[2]);}
        else{
            for(int i=3; i<=n; i++){
                a[i]=(a[i-1]+a[i-2])%10007;
            }
            System.out.println(a[n]);
        }
    }
}