import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 스택 선언
        Stack<Character> stack = new Stack<>();  
        
        // 괄호가 있는 문자열을 쪼개서 문자 배열로 저장
        char a[] = s.toCharArray();
        
        // 문자 배열의 요소를 모두 꺼내기
        for(char c : a){
            // 여는 괄호가 있으면 stack에 저장
            if(c == '('){
                stack.push(c);
            }
            // 닫는 괄호일 때
            else{
                // 짝이 안맞으면
                if(stack.isEmpty())return false;
                // 짝이맞으면 제거
                stack.pop();
            }
        }
        // 짝이 다 맞으면 true 반환
        return stack.isEmpty();
    }
}