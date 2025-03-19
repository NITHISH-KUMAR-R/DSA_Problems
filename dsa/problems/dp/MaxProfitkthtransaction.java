package dsa.problems.dp;

public class MaxProfitkthtransaction {
    /**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */
    class Solution {
        public int maxProfit(int prices[], int K) {
            if (K == 0 || prices.length == 0) {
                return 0;
            }
            int dp[][] = new int[K+1][prices.length];

            for (int i = 1; i <=K; i++) {
                int maxDiff = -prices[0];
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                    maxDiff = Math.max( dp[i-1][j] - prices[j],maxDiff);
                }
            }
            return dp[K][prices.length-1];
        }

    }
}
