package dsa.problems.strings;

import java.util.Stack;

public class DISmallesString {
    //2375. Construct Smallest Number From DI String
    //Best Approach own Codecd
    class Solution {
        public String smallestNumber(String pattern) {

            StringBuilder sb = new StringBuilder();
            Stack<Integer> st = new Stack<>();
            int i =1;
            for(char c : pattern.toCharArray()){
                st.push(i++);
                if(c=='I'){
                    while(!st.isEmpty()){
                        sb.append(st.pop());
                    }

                }

            }
            st.push(i);
            while(!st.isEmpty()){
                sb.append(st.pop());
            }


            return sb.toString();

        }
    }
}
