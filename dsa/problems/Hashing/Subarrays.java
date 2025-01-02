package dsa.problems.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Subarrays {
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {

            int curr =0,  ans =0;
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,1);

            for(int i :nums){
                curr+=i;
                int remainder = (curr % k + k) % k;
                if(map.containsKey(remainder)){
                    ans+=map.get(remainder);
                }

                map.put(remainder, map.getOrDefault(remainder,0)+1);
            }
            return ans;
        }
    }
    class Solution2c {
        public int subarraySum(int[] nums, int k) {
            int ans = 0 , curr =0;

            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            for(int i:nums){
                curr+=i;
                if(map.containsKey(curr-k)){
                    ans+=map.get(curr-k);
                }map.put(curr, map.getOrDefault(curr,0)+1);
            }
            return ans;
        }
    }
}
