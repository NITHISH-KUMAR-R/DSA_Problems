package dsa.problems.dp;

public class HouseRobber2 {
    class Solution {
        private int maxLoot(int[] arr, int start, int end) {
            int prev2 = 0, prev1 = 0;

            for (int i = start; i <= end; i++) {
                int curr = Math.max(arr[i] + prev2, prev1);
                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }

        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0]; // Edge case: Only one house

            return Math.max(maxLoot(nums, 0, n - 2), maxLoot(nums, 1, n - 1));
        }
    }
}
