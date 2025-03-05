package dsa.problems.dp;

import java.util.Arrays;

public class LongestIncreasingSuqDeq {
    class Solution {
        static int lis(int arr[]) {
            // code here
            int n = arr.length;
            if (n == 0) return 0;

            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int maxLIS = 1;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLIS = Math.max(maxLIS, dp[i]);
            }

            return maxLIS;

        }
    }
}
