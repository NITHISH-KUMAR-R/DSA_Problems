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
}
//GFG
///Input: coins[] = [1, 2, 3], sum = 4
//Output: 4
//Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].

//518. Coin Change II - leetcode