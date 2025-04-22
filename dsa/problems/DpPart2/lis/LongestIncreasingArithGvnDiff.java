package dsa.problems.DpPart2.lis;

import java.util.HashMap;

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

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // HashMap to store the longest subsequence length for each value
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        // Iterate through the array
        for (int num : arr) {
            // If there's a subsequence ending with num - difference, extend it
            int prev = num - difference;
            int newLength = map.getOrDefault(prev, 0) + 1;
            map.put(num, newLength);

            // Update the maxLength
            maxLength = Math.max(maxLength, newLength);
        }

        return maxLength;
    }
}

