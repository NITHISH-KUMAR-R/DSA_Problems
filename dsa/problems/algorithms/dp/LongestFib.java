package dsa.problems.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestFib {


    public class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int n = arr.length;
            Map<Integer, Integer> indexMap = new HashMap<>(); // Map number -> index
            int[][] dp = new int[n][n]; // DP table
            int maxLength = 0;

            // Populate index map for quick lookups
            for (int i = 0; i < n; i++) {
                indexMap.put(arr[i], i);
            }

            // Iterate through all pairs (j, i) where j < i
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int x = arr[i] - arr[j]; // Expected previous Fibonacci number
                    if (x < arr[j] && indexMap.containsKey(x)) { // Ensure valid sequence
                        int k = indexMap.get(x); // Get index of x
                        dp[j][i] = dp[k][j] + 1; // Extend previous sequence
                        maxLength = Math.max(maxLength, dp[j][i]); // Track longest length
                    } else {
                        dp[j][i] = 2; // Base case: minimum valid Fibonacci-like length
                    }
                }
            }

            return maxLength > 2 ? maxLength : 0; // Must be at least length 3
        }}
}
