package dsa.problems.stack;

public class MaxValidParenthesisLength {
    class Solution {
        static int maxLength(String s) {



            // Stack<Integer> st = new Stack<>();
            // st.push(-1); // Initialize stack with -1 for base index
            // int maxLen = 0;

            // for (int i = 0; i < s.length(); i++) {
            //     if (s.charAt(i) == '(') {
            //         st.push(i);
            //     } else {
            //         st.pop(); // Pop the last index

            //         if (!st.isEmpty()) {
            //             maxLen = Math.max(maxLen, i - st.peek()); // Calculate length
            //         } else {
            //             st.push(i); // Push current index if stack is empty
            //         }
            //     }
            // }

            // return maxLen;

            int left =0; int right =0;

            int max =0;

            for(int i =0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    left++;
                }else{
                    right++;
                }
                if(left == right){
                    max = Math.max(max,2*right);
                }else if(right > left){
                    left =0;
                    right=0;
                }
            }

            left =0; right =0;
            for(int i =s.length()-1 ;i>=0;i--){
                if(s.charAt(i)==')'){
                    right++;
                }else{
                    left++;
                }
                if(left==right){
                    max = Math.max(max,2*left);
                }else if(left>right){
                    left=0;
                    right=0;
                }
            }
            return max;

        }
    }
}
