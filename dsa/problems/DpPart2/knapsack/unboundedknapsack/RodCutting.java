package dsa.problems.DpPart2.knapsack.unboundedknapsack;

public class RodCutting {
        public int cutRod(int[] price) {
            // code here
            int n  = price.length;

            int dp[] = new int[n+1];

            for(int len =1;len<=n;len++){
                for(int rod = len ;rod<=n;rod++){
                    dp[rod] = Math.max(dp[rod], dp[rod-len]+price[len-1]);
                }
            }

            return dp[n];
        }

    class Solution {
        public int cutRod(int[] price) {
            // code here
            int n  = price.length;

            int dp[] = new int[n+1];

            for(int i =1;i<=n;i++){//len
                for(int j = i ;j<=n;j++){//rod
                    dp[j] = Math.max(dp[j], dp[j-i]+price[i-1]);
                }
            }

            return dp[n];
        }
    }
}
