package dsa.problems.DpPart2.lcs;

public class DistinctSubSequences {
    class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length();
            int n = t.length();
            int[][] dp = new int[m + 1][n + 1];

            dp[0][0] =1;

            for(int i =1;i<=s.length();i++){
                dp[i][0] = 1;
            }

            for(int i =1;i<=s.length();i++){
                for(int j =1;j<=t.length();j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        int include = dp[i-1][j-1];
                        int exclude  = dp[i-1][j];
                        dp[i][j]= include+exclude;
                    }else{
                        int exclude = dp[i-1][j];
                        dp[i][j]=exclude;
                    }

                }
            }

            return dp[m][n];
        }
    }

}
