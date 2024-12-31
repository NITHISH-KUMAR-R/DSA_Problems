package dsa.problems.Hashing;

import java.util.HashSet;

public class LongestConsequtive {
    class Solution {
        public int longestConsecutive(int[] nums) {

            HashSetC<Integer> set = new HashSet<>();
            for(int num :nums){
                set.add(num);
            }

            int length =0;
            for(int num : nums){
                if(!set.contains(num-1)){
                    int curr = num;
                    int currLen = 1;
                    while(set.contains(curr+1)){
                        curr++;
                        currLen++;
                    }
                    length = Math.max(length, currLen);
                }
            }

            return length;
        }
    }
}
