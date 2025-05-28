import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] st = new String[3];
        int num=0;
        int index=0;

        for (int i = 0; i < 3; i++) {
            st[i] = br.readLine();
        }
        for(int i = 0; i < 3; i++) {
            if(!st[i].equals("Fizz") && !st[i].equals("Buzz") && !st[i].equals("FizzBuzz")) {
                num=Integer.parseInt(st[i]);
                index=i;
                break;
            }
        }

        if(index==0){
            num+=3;
        }
        else if(index==1){
            num+=2;
        }
        else if(index==2){
            num+=1;
        }

        if(num%3==0 && num%5==0) {
            System.out.println("FizzBuzz");
        }
        else if(num%3==0 && num%5>0) {
            System.out.println("Fizz");
        }
        else if(num%5==0 && num%3>0) {
            System.out.println("Buzz");
        }
        else System.out.println(num);
    }
}