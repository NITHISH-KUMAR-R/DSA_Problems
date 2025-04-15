package dsa.problems.slidingWindow;

public class MinSizeSubArray {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minWinLength =Integer.MAX_VALUE;
            int low =0 ;
            int high =0;
            int currSum =0;

            while(high<nums.length){
                currSum += nums[high];
                high++;

                while(currSum>=target){
                    int currWindow = high-low;
                    minWinLength = Math.min(minWinLength, currWindow);
                    currSum -= nums[low];
                    low++;
                }
            }
            return minWinLength == Integer.MAX_VALUE ?0 :minWinLength;
        }
    }
}
