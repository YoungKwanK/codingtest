
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			char[] commands = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();

			Deque<Integer> deque = new ArrayDeque<>();
			s = s.substring(1, s.length() - 1); // [ ] 제거

			if (!s.isEmpty()) {
				String[] nums = s.split(",");
				for (String num : nums) {
					deque.add(Integer.parseInt(num));
				}
			}

			boolean reverse = false;
			boolean error = false;

			for (char cmd : commands) {
				if (cmd == 'R') {
					reverse = !reverse;
				} else if (cmd == 'D') {
					if (deque.isEmpty()) {
						System.out.println("error");
						error = true;
						break;
					}
					if (!reverse) deque.pollFirst();
					else deque.pollLast();
				}
			}

			if (error) continue;

			StringBuilder sb = new StringBuilder();
			sb.append("[");

			if (!deque.isEmpty()) {
				if (!reverse) {
					Iterator<Integer> it = deque.iterator();
					sb.append(it.next());
					while (it.hasNext()) sb.append(",").append(it.next());
				} else {
					Iterator<Integer> it = deque.descendingIterator();
					sb.append(it.next());
					while (it.hasNext()) sb.append(",").append(it.next());
				}
			}

			sb.append("]");
			System.out.println(sb);
		}
	}
}
