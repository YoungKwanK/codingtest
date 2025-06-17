
import java.util.*;
import java.io.*;

public class Main {

    // 문서 정보를 저장할 클래스 (번호 + 중요도)
    static class Document {
        int index;     // 문서가 원래 몇 번째에 있었는지
        int priority;  // 문서의 중요도

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 반복
        while (T-- > 0) {
            // 문서 개수 N, 알고 싶은 문서의 위치 M
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 중요도들을 공백으로 한 줄 받아오기
            String[] input = br.readLine().split(" ");

            // 문서를 저장할 큐
            Queue<Document> queue = new LinkedList<>();

            // 중요도 별 개수를 저장할 배열 (중요도는 1~9)
            int[] priorityCount = new int[10];

            // 문서를 큐에 넣고, 중요도 개수 기록하기
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(input[i]);
                queue.offer(new Document(i, priority)); // 문서 저장
                priorityCount[priority]++; // 해당 중요도 개수 증가
            }

            int printCount = 0; // 출력된 문서 수

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                // 큐의 맨 앞 문서를 꺼냄
                Document doc = queue.poll();

                // 뒤에 더 중요한 문서가 있는지 확인
                boolean hasHigher = false;
                for (int i = doc.priority + 1; i <= 9; i++) {
                    if (priorityCount[i] > 0) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    // 더 중요한 문서가 있으면 → 다시 뒤로 보내기
                    queue.offer(doc);
                } else {
                    // 현재 문서를 출력함
                    printCount++; // 출력 횟수 증가
                    priorityCount[doc.priority]--; // 해당 중요도 개수 줄이기

                    // 내가 찾는 문서였다면 출력 순서 출력하고 종료
                    if (doc.index == M) {
                        System.out.println(printCount);
                        break;
                    }
                }
            }
        }
    }
}
