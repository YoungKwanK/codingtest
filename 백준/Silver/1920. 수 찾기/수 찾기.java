import java.util.*;
import java.io.*;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정수의 갯수 N받기
        int N = Integer.parseInt(br.readLine());
        // 정수를 저장할 배열 선언
        int[] numN = new int[N];
        // 정수들 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 받은 정수를 배열에 저장
        for(int i=0; i<N; i++){
            numN[i]=Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(numN);
        
        // 정수의 갯수 M 받기
        int M = Integer.parseInt(br.readLine());
        // 정수들 받기
        st = new StringTokenizer(br.readLine());
        // 한번에 받은 정수를 뽑아내며 배열에 있는 지 확인하고 출력
        for(int i=0; i<M; i++){
            // 정수 뽑아내기
            int temp = Integer.parseInt(st.nextToken());
            // 배열에 정수가 있다면 1출력
            if(Arrays.binarySearch(numN, temp)>=0) System.out.println(1);
            // 없다면 0출력
            else System.out.println(0);
        }
	}
	
}
