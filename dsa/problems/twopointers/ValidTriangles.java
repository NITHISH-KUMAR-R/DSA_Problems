package dsa.problems.twopointers;

import java.util.Arrays;

public class ValidTriangles {
    //611. Valid Triangle Number
    class Solution {
        public int triangleNumber(int[] nums) {
            int ans =0;
            Arrays.sort(nums);
            for(int i = nums.length-1;i>=0;i--){
                int start =0, end =i-1;
                while(start<end){
                    if(nums[start]+nums[end]>nums[i]){
                        ans += end-start;
                        end--;
                    }else{
                        start++;
                    }
                }
            }
            return ans;
        }
    }
}
