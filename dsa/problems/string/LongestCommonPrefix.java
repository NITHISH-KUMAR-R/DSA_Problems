package dsa.problems.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            StringBuilder sb = new StringBuilder();

            Arrays.sort(strs);
            char[] s1 = strs[0].toCharArray();
            char[] s2 = strs[strs.length-1].toCharArray();

            for(int i =0;i<s1.length;i++){
                if( s1[i] != s2[i]){
                    break;
                }
                sb.append(s1[i]);
            }

            return sb.toString();

        }
    }
}
