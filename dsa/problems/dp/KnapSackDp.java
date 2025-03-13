package dsa.problems.dp;

public class KnapSackDp {
    class Solution {
        static int knapsack(int W, int val[], int wt[]) {
            // code here
            int n = val.length;
            int dp[] = new int[W + 1];

            for (int i = 0; i < n; i++) {
                for (int j = W; j >= wt[i]; j--) {
                    dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
                }
            }
            return dp[W];

        }
    }
    class Solution2 {
        // Function to return max value that can be put in knapsack of capacity W.
        static int knapSack(int W, int wt[], int val[]) {
            // your code here
            int K[][] = new int[wt.length + 1][W + 1];
            for (int i = 0; i <= val.length; i++) {
                for (int j = 0; j <= W; j++) {
                    if (i == 0 || j == 0) {
                        K[i][j] = 0;
                        continue;
                    }
                    if (j - wt[i - 1] >= 0) {
                        K[i][j] = Math.max(K[i - 1][j], K[i - 1][j - wt[i - 1]] + val[i - 1]);
                    } else {
                        K[i][j] = K[i - 1][j];
                    }
                }
            }
            return K[val.length][W];
        }
    }

}




//gfg0 - 1 Knapsack Problemc