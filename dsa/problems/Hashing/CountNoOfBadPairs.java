package dsa.problems.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNoOfBadPairs {
    //. Count Number of Bad Pairs
    //. Count Number of Bad Pairs

    class Solution {

        public long countBadPairs(int[] nums) {
            long badPairs = 0;
            Map<Integer, Integer> diffCount = new HashMap<>();

            for (int pos = 0; pos < nums.length; pos++) {
                int diff = pos - nums[pos];

                // Count of previous positions with same difference
                int goodPairsCount = diffCount.getOrDefault(diff, 0);

                // Total possible pairs minus good pairs = bad pairs
                badPairs += pos - goodPairsCount;

                // Update count of positions with this difference
                diffCount.put(diff, goodPairsCount + 1);
            }

            return badPairs;
        }
    }

    class Solution2 {
        public long countBadPairs(int[] nums) {

            long count =0;
            Map<Integer,Integer> map = new HashMap<>();
            long goodPair = 0;
            int n = nums.length;

            for(int i =0;i<nums.length;i++){
                int key = nums[i]-i;
                goodPair +cd= map.getOrDefault(key,0);
                map.put(key,map.getOrDefault(key,0)+1);
            }

            long totalPairs = (n*(n-1L))/2;
            return totalPairs - goodPair;
        }
    }

}
