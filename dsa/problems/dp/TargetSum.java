package dsa.problems.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {

            Map<Integer,Integer> dp = new HashMap<>();
            dp.put(0,1);

            for(int num:nums){
                Map<Integer,Integer> nextDp = new HashMap<>();
                for(int sum : dp.keySet()){
                    int oldKeyCount = dp.get(sum);
                    int keyPlusSum = sum+num;
                    nextDp.put(keyPlusSum,nextDp.getOrDefault(keyPlusSum,0)+oldKeyCount);
                    int keyMinusSum = sum-num;
                    nextDp.put(keyMinusSum,nextDp.getOrDefault(keyMinusSum,0)+oldKeyCount);
                }
                dp = nextDp;

            }

            return dp.getOrDefault(target,0);
        }
    }
}
