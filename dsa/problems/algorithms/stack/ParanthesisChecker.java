package dsa.problems.algorithms.stack;

import java.util.Stack;

public class ParanthesisChecker {
    class Solution {
        static boolean isBalanced(String s) {
            // code here
            Stack<Character> st  = new Stack<>();

            for(char c : s.toCharArray()){
                if(c=='[' || c=='{' || c=='(' ) {
                    st.push(c);
                }else{
                    if(st.isEmpty()){
                        return false;
                    }
                    char check = st.peek();
                    if ((check == '(' && c == ')') ||
                            (check == '{' && c == '}') ||
                            (check == '[' && c == ']')) {
                        st.pop();
                    }else{
                        return false;
                    }
                }
            }

            return st.isEmpty();
        }
    }

}
