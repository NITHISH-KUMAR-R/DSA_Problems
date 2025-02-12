package dsa.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfpair {
    //leetcode 2342
    class Solution {
        int getSum(int n){
            int sum =0;
            while(n>0){
                sum += n%10;
                n= n/10;
            }
            return sum;
        }
        public int maximumSum(int[] nums) {

            Map<Integer,Integer> map = new HashMap<>();
            int maxSum =-1;
            for(int i =0;i<nums.length;i++){
                int sum = getSum(nums[i]);
                if(map.containsKey(sum)){
                    maxSum  = Math.max(maxSum , nums[i]+map.get(sum));
                    int value = Math.max(map.get(sum),nums[i]);
                    map.put(sum,value);
                }else{
                    map.put(sum,nums[i]);
                }
            }
            return maxSum;
        }
    }
}
