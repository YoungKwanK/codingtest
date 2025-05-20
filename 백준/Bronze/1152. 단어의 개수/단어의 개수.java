import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();  // 여기서 바로 trim 적용

        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            String[] s_array = s.split(" ");
            System.out.println(s_array.length);
        }
    }
}
