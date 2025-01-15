package dsa.problems.subArrayInterview;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {
    class Solution {
        public int longestSubarray(int[] arr, int k) {
            int currentSum = 0; // Tracks the cumulative sum
            int longest = 0;    // Tracks the length of the longest subarray
            Map<Integer, Integer> prefixSumMap = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                currentSum += arr[i];

                // Check if the current sum equals k (from the start of the array)
                if (currentSum == k) {
                    longest = i + 1; // The subarray spans from index 0 to i
                }

                // Check if removing a previous prefix sum gives a subarray sum of k
                if (prefixSumMap.containsKey(currentSum - k)) {
                    longest = Math.max(longest, i - prefixSumMap.get(currentSum - k));
                }

                // Store the first occurrence of the current prefix sum
                if (!prefixSumMap.containsKey(currentSum)) {
                    prefixSumMap.put(currentSum, i);
                }
            }

            return longest;
        }
    }

}
