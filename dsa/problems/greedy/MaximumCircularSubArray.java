package dsa.problems.greedy;

public class MaximumCircularSubArray {
        public int kadane(int nums[]){
            int curr = nums[0];
            int max = nums[0];
            for(int i =1;i<nums.length;i++){
                curr = Math.max(nums[i] , curr+nums[i]);
                max = Math.max(curr, max);
            }
            return max;
        }
        public int maxSubarraySumCircular(int[] nums) {
            int totalSum =0;
            for(int i: nums){
                totalSum +=i;
            }
            int maxSum = kadane(nums);
            for(int i =0;i<nums.length;i++){
                nums[i] = nums[i]*-1;
            }
            int minSum = kadane(nums);

            if(totalSum==-minSum){
                return maxSum;
            }

            return Math.max(maxSum , totalSum+minSum);
        }
    }

