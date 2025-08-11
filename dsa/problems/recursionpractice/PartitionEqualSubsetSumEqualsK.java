package dsa.problems.recursionpractice;

public class PartitionEqualSubsetSumEqualsK {
        public boolean recursion(int start, int currBucket, int eachBucketValue, int k, int nums[], boolean[] used) {
            if (k == 1)
                return true;

            if (currBucket > eachBucketValue)
                return false;
            if (eachBucketValue == currBucket) {
                return recursion(0, 0, eachBucketValue, k - 1, nums,  used);
            }

            for(int i = start ;i<nums.length;i++){
                if(!used[i]){
                    used[i] = true;
                    if(recursion(i+1,currBucket+nums[i],eachBucketValue, k, nums, used )){
                        return true;
                    }
                    used[i] = false;
                }
            }
            return false;
        }

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int totalSum = 0;
            for (int i : nums) {
                totalSum += i;
            }

            if (totalSum % k != 0)
                return false;
            int eachBucketValue = totalSum / k;

            return recursion(0, 0, eachBucketValue, k, nums, new boolean[nums.length]);

        }

}
