package dsa.problems.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChar {
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            Set<Character> set = new HashSet<>();

            int maxLength =0;
            int left =0;
            for(int right =0;right <s.length();right++){
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(s.charAt(right));
                maxLength = Math.max(maxLength,right-left+1);
            }
            return maxLength;

        }
    }
}
