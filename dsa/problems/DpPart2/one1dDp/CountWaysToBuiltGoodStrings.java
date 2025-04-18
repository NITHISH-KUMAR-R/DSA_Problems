package dsa.problems.DpPart2.one1dDp;

public class CountWaysToBuiltGoodStrings {
    class Solution {
        public int countGoodStrings(int low, int high, int zero, int one) {
            final int MOD = 1_000_000_007;

            int dp[] = new int [high+1];
            dp[0]= 1;
            for(int i =0;i<=high;i++){
                if(dp[i]>0){
                    if(i+zero<=high){
                        dp[i+zero] = (dp[i+zero]+ dp[i])%MOD;
                    }
                    if(i+one<=high){
                        dp[i+one] = (dp[i+one]+ dp[i])%MOD;
                    }
                }
            }
            int totalWays =0;
            for(int i =low ;i<=high;i++){
                totalWays = (totalWays + dp[i]) % MOD;
            }
            return totalWays;
        }
    }
}

//2466. Count Ways To Build Good Strings
