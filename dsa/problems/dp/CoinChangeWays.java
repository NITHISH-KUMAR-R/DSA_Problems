package dsa.problems.dp;

public class CoinChangeWays {
    class Solution {
        public int count(int coins[], int sum) {
            int[] dp = new int[sum + 1];
            dp[0] = 1; // Base case: 1 way to make sum 0 (by choosing nothing)

            for (int coin : coins) {
                for (int j = coin; j <= sum; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            return dp[sum];
        }
    }
    class Solution2Darray {
        public int count(int coins[], int sum) {
            int n = coins.length;
            int[][] dp = new int[n + 1][sum + 1];

            // Base case: If sum is 0, there is 1 way (by selecting no coins)
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }

            // Fill the DP table
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (coins[i - 1] > j) { // Exclude the coin if it's larger than sum
                        dp[i][j] = dp[i - 1][j];
                    } else { // Include the coin + exclude the coin
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }
                }
            }

            return dp[n][sum];
        }
    }
}
//GFG
///Input: coins[] = [1, 2, 3], sum = 4
//Output: 4
//Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

//518. Coin Change II - leetcode