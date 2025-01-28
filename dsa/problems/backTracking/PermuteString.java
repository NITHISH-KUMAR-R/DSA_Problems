package dsa.problems.backTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PermuteString {
    class Solution {

        public void permute(char[] c, StringBuilder ds, ArrayList<String> ans, boolean[] freq){

            if(ds.length() == c.length){
                ans.add(ds.toString());
                return;
            }

            for(int i = 0; i < c.length; i++){
                // Corrected condition to skip duplicates
                if(freq[i] || i > 0 && c[i] == c[i-1] && freq[i-1]) {
                    continue;
                }

                freq[i] = true; // Mark the character as used
                ds.append(c[i]); // Add the character to the current path
                permute(c, ds, ans, freq); // Recur for the next position
                ds.deleteCharAt(ds.length() - 1); // Backtrack: remove the character from the path
                freq[i] = false; // Mark the character as unused
            }
        }

        public ArrayList<String> findPermutation(String s) {
            // Code here
            ArrayList<String> ans = new ArrayList<>();
            StringBuilder ds = new StringBuilder();
            char[] c = s.toCharArray();
            Arrays.sort(c); // Sort the characters to handle duplicates easily
            boolean[] freq = new boolean[c.length];
            permute(c, ds, ans, freq);
            return ans;
        }
    }
}
