package dsa.problems.arrays;

import java.util.HashMap;

public class ContiguousArray {
        //GFG Largest subarray of 0's and 1's
        //Leetcode 525. Contiguous Array
    class Solution {
        public int findMaxLength(int[] nums) {
            int prefixSum =0;
            int ans =0;
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,-1);
            for(int i =0;i<nums.length;i++){
                prefixSum += nums[i] == 1 ? 1 : -1;

                if(map.containsKey(prefixSum)){
                    ans = Math.max(ans, i-map.get(prefixSum));
                }else{
                    map.put(prefixSum,i);
                }
            }
            return ans;
        }
    }
}
