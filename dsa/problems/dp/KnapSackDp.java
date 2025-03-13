package dsa.problems.dp;

public class KnapSackDp {
    class Solution {
        static int knapsack(int W, int val[], int wt[]) {
            // code here
            int n = val.length;
            int dp[] = new int[W + 1];

            for (int i = 0; i < n; i++) {
                for (int w = W; w >= wt[i]; w--) {
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
                }
            }
            return dp[W];

        }
    }

}

//gfg0 - 1 Knapsack Problemc