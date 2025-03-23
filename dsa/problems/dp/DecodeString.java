package dsa.problems.dp;

import java.util.Stack;

public class DecodeString {
    class Solution {
        public String decodeString(String s) {

            Stack<Integer> numStack = new Stack<>();
            Stack<String> strStack = new Stack<>();


            StringBuilder str = new StringBuilder();
            int num = 0;

            for(char c: s.toCharArray()){
                if(Character.isDigit(c)){
                    num = num * 10 + (c-'0');
                }
                else if(c=='['){
                    numStack.push(num);
                    strStack.push(str.toString());
                    //reset
                    num = 0;
                    str = new StringBuilder();
                }
                else if(c==']'){
                    int times = numStack.pop();
                    StringBuilder temp = new StringBuilder(strStack.pop());
                    for (int i = 0; i < times; i++) {
                        temp.append(str);
                    }
                    str = temp;

                }else{
                    str.append(c);
                }
            }

            return str.toString();

        }
    }
}
