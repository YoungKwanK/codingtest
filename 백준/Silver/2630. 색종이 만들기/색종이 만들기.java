import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[][] paper;
    static int white;
    static int blue;
    public static void division(int x, int y, int size){
        int sum=0;
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                sum+=paper[i][j];
            }
        }
        if(sum==size*size){
            blue++;
        }
        else if(sum==0){
            white++;
        }
        else{
            division(x, y+size/2, size/2);
            division(x+size/2, y, size/2);
            division(x, y, size/2);
            division(x+size/2, y+size/2, size/2);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N+1][N+1];
        white = blue = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        division(0, 0, N);
        System.out.println(white +"\n" + blue);
    }
}