package dsa.problems.string;

import java.util.Stack;

public class Interview {
    class Solution {
        public String clearDigits(String s) {
            int i =0;
            Stack<Character> st = new Stack<>();
            StringBuilder sb = new StringBuilder();
            //  for(char c: s.toCharArray()){
            //     if(Character.isDigit(c)){
            //         st.pop();
            //     }else{
            //     st.push(c);
            //     }
            //  }
            //  for(char ch : st){
            //     sb.append(ch);
            //  }
            //  return sb.toString();


            for(char c : s.toCharArray()){
                if(Character.isDigit(c)){
                    sb.deleteCharAt(sb.length()-1);
                }else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
