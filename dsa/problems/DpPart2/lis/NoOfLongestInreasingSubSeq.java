package dsa.problems.DpPart2.lis;

import java.util.Arrays;

public class NoOfLongestInreasingSubSeq {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;

            int[] dp = new int[n];       // dp[i] = length of LIS ending at i
            int[] count = new int[n];    // count[i] = number of LIS ending at i

            Arrays.fill(dp, 1);          // Every element is at least a subsequence of length 1
            Arrays.fill(count, 1);       // Initially, one way to form subsequence of length 1

            int maxLen = 1;              // At least LIS of length 1 exists

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j]; // new length, inherit count from j
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j]; // same length, add more ways
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                if (dp[i] == maxLen) {
                    result += count[i];
                }
            }

            return result;
        }
    }

}
