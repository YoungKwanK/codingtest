import java.util.*;

public class Solution {
    public Stack solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(st.isEmpty()){
                st.add(arr[i]);
            }
            else if(st.peek()!=arr[i]) st.add(arr[i]);
        }

        return st;
    }
}