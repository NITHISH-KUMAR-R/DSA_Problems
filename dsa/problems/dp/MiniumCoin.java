package dsa.problems.dp;

import java.util.Arrays;

public class MiniumCoin {
    class Solution {

        public int minCoins(int coins[], int sum) {
            // code here

            int dp[] = new int[sum+1];

            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;

            for(int coin : coins){
                for(int i = coin ;i<=sum;i++){
                    if(dp[i-coin]!=Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],1+dp[i-coin]);
                    }
                }
            }

            return dp[sum] == Integer.MAX_VALUE ?-1:dp[sum];
        }
    }
    class Solution2 {

        public int minCoins(int coins[], int sum) {
            // code here

            int dp[][] = new int[coins.length+1][sum+1];

            for (int i = 0; i <= coins.length; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
            }
            for (int i = 0; i <= coins.length; i++) {
                dp[i][0] = 0;
            }

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (coins[i - 1] > j) {  // If coin is greater than sum, exclude it
                        dp[i][j] = dp[i - 1][j];
                    } else {  // Otherwise, include or exclude the coin (whichever is smaller)
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                    }
                }
            }
            return dp[coins.length][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][sum];
        }
    }
}

//Input: coins[] = [25, 10, 5], sum = 30
//Output: 2
//Explanation: Minimum 2 coins needed, 25 and 5

