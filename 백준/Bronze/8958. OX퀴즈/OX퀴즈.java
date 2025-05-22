import java.sql.SQLOutput;
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String st = "";
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            st = sc.next();

            int score=0;
            int sequence=1;
            String []st_char = st.split("");
            for(int j=0; j<st_char.length; j++){
                if(st_char[j].equals("O")){
                    score+=sequence;
                    sequence++;
                }
                else if(st_char[j].equals("X")){
                    sequence=1;
                }
            }
            System.out.println(score);
        }
    }
}