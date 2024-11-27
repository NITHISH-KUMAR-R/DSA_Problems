package dsa.problems.subArrayInterview;


class MaxCircularSubarraySum {
    public int kadane(int arr[]){
        int max = arr[0];
        int curr = arr[0];

        for(int i =1;i<arr.length;i++){
            curr = Math.max(arr[i], arr[i]+curr);
            max = Math.max(curr, max);
        }
        return max;
    }
    public int maxSubarraySumCircular(int[] nums) {

        int total =0;
        for(int i:nums){
            total+=i;
        }
        int maxSum = kadane(nums);

        for(int i =0;i<nums.length;i++){
            nums[i] = nums[i]*-1;
        }

        int minSum = kadane(nums);

        if(total==-minSum){
            return maxSum;
        }

        return Math.max(maxSum, minSum+total);


    }
}