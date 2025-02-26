package dsa.problems.algorithms;

public class MaximumAbsoluteSumSubarray {
    //1749. Maximum Absolute Sum of Any Subarray
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int max = nums[0], min = nums[0];
            int currMax = nums[0], currMin = nums[0];

            for(int i =1;i<nums.length;i++){
                currMax = Math.max(nums[i], nums[i]+currMax);
                currMin = Math.min(nums[i], nums[i]+currMin);
                max = Math.max(currMax, max);
                min = Math.min(currMin, min);
            }
            return Math.max(max, Math.abs(min));
        }
    }

}
