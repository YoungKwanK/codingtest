import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 N 받기
        int N =Integer.parseInt(br.readLine());
        br.close();

        //
        int temp=2;
        int room=2;
        for(int i=1; i<=N; i++){
            if(N==1){
                System.out.println(room-1);
                break;
            }
            else if(temp<=N && N<temp+i*6){
                System.out.println(room);
                break;
            }
            temp=temp+i*6;
            room++;
        }
    }
}