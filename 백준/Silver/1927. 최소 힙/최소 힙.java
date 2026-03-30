
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 연산의 수 N
        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 (최소 힙)
        Queue<Integer> nums = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(num != 0) {
                // 0이 아니면 추가
                nums.add(num);
            } else {
                // 0이면 가장 작은 값 출력 및 제거
                if(nums.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(nums.remove());
                }
            }
        }
    }
}