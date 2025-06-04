import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;  // 종료 조건

            Stack<Character> stack = new Stack<>();
            boolean balanced = true;

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) balanced = false;

            System.out.println(balanced ? "yes" : "no");
        }
    }
}
