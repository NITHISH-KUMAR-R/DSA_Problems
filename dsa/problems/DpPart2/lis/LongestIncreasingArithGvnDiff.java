package dsa.problems.DpPart2.lis;

public class LongestIncreasingArithGvnDiff {
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int n = arr.length;
            // DP array to store the length of the longest subsequence ending at each element
            int[] dp = new int[n];
            int maxLength = 0;

            // Initialize the DP array with 1 because every element can form a subsequence of length 1 by itself
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }

            // Iterate through each element in the array
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // If the difference between arr[i] and arr[j] is equal to the given difference
                    if (arr[i] - arr[j] == difference) {
                        // Extend the subsequence ending at arr[j] by including arr[i]
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // Update maxLength after each element's comparison
                maxLength = Math.max(maxLength, dp[i]);
            }

            return maxLength;
        }
    }

}
