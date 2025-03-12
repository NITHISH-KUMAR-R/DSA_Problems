package dsa.problems.dp;

public class EditDistance {
    class Solution {
        public int editDistance(String s1, String s2) {
            // Code here
            int n = s1.length();
            int m = s2.length();
            int[][] dp = new int[n+1][m+1];
            for(int i =0; i <= n; i++) {
                dp[i][0] = i;
            }
            for(int i =0; i <= m; i++) {
                dp[0][i] = i;
            }

            for(int i =1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    else {
                        dp[i][j] = 1 + Math.min(dp[i][j-1],
                                Math.min(dp[i-1][j], dp[i-1][j-1]));
                    }
                }
            }
            return dp[n][m];
        }
    }
}

//GFGEdit Distancec

class Solution2 {
    public int minDistance(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for(int i =0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else{
                    int delete = dp[i-1][j]+1;
                    int insert = dp[i][j-1]+1;
                    int replace = dp[i-1][j-1]+(s1.charAt(i-1)==s2.charAt(j-1) ?0:1);
                    dp[i][j]= Math.min(delete,Math.min(insert,replace));
                }

            }

        }
        return dp[s1.length()][s2.length()];


    }
}
