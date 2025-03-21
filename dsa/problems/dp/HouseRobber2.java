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

    //Used Same Approach
    class Solution2 {
        static int robHelper(int nums[]){
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];

            int dp [] = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);

            for(int i =2;i<nums.length;i++){
                dp[i] = Math.max(dp[i-2]+nums[i] , dp[i-1]);
            }

            return dp[nums.length-1];
        }


        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];

            int skipFirstHouse [] = new int[nums.length-1];
            int skipLastHouse [] = new int[nums.length-1];

            for (int i =0;i<nums.length-1;i++){
                skipFirstHouse[i] = nums[i];
                skipLastHouse[i] = nums[i+1];

            }
            return Math.max(robHelper(skipFirstHouse),robHelper(skipLastHouse));
        }
    }
}
