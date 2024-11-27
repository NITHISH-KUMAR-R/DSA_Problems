package dsa.problems.subArrayInterview;

class MaxCircularSubarraySum {

    // Helper function: Kadane's algorithm to find the maximum subarray sum
    public int kadane(int arr[]) {
        int max = arr[0]; // Initialize max sum to the first element
        int curr = arr[0]; // Initialize current sum to the first element

        // Traverse the array to calculate the maximum subarray sum
        for (int i = 1; i < arr.length; i++) {
            // Update current sum: either start fresh from current element or continue with the current subarray
            curr = Math.max(arr[i], arr[i] + curr);

            // Update maximum sum so far
            max = Math.max(curr, max);
        }
        return max; // Return the maximum subarray sum
    }

    // Function to find the maximum circular subarray sum
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0; // Total sum of the array

        // Calculate total sum of the array
        for (int i : nums) {
            total += i;
        }

        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxSum = kadane(nums);

        // Step 2: Find the minimum subarray sum by inverting the array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * -1; // Invert the sign of each element
        }

        // Minimum subarray sum is now the negative of Kadane's result on the inverted array
        int minSum = kadane(nums);

        // Edge case: If the entire array is part of the minimum sum
        if (total == -minSum) {
            return maxSum; // Return the maximum sum (ignoring circular calculation)
        }

        // Step 3: Calculate the maximum circular subarray sum and return the larger of maxSum or (total - minSum)
        return Math.max(maxSum, minSum + total);
    }
}
