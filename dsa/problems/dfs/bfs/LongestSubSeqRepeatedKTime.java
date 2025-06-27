package dsa.problems.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubSeqRepeatedKTime {
    class Solution {
        public boolean isKTimeRepeated(String temp, String src,int k){

            int i =0;
            int count =0;
            for(char c : src.toCharArray()){
                if(c ==temp.charAt(i)){
                    i++;
                    if(i==temp.length()){
                        i=0;
                        count++;
                        if(count==k) return true;
                    }
                }
            }
            return false;
        }
        public String longestSubsequenceRepeatedK(String s, int k) {
            Queue<String> q = new LinkedList<>();
            q.add("");
            String ans ="";

            while(!q.isEmpty()){
                String str = q.poll();
                for(char c = 'a' ; c<='z';c++){
                    String temp = str+c;
                    if(isKTimeRepeated(temp,s,k)){
                        ans = temp;
                        q.add(temp);
                    }
                }
            }
            return ans;
        }
    }

    /// class Solution { //GFG
    ///     public int LongestRepeatingSubsequence(String s) {
    ///         int n = s.length();
    ///         int[][] dp = new int[n+1][n+1];
    ///
    ///         for(int i = 1; i <= n; i++) {
    ///             for(int j = 1; j <= n; j++) {
    ///                 if(s.charAt(i-1) == s.charAt(j-1) && i != j)
    ///                     dp[i][j] = 1 + dp[i-1][j-1];
    ///                 else
    ///                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    ///             }
    ///         }
    ///         return dp[n][n];
    ///     }
    /// }
}
