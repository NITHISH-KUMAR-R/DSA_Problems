package dsa.problems.MAANG;

import java.util.HashMap;
import java.util.Map;

public class LongestConsequtiveNumber {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer,Boolean> map = new HashMap<>();

            for(int num:nums){
                map.put(num,Boolean.FALSE);
            }
            int maxLength=0;

            for(int num: nums){
                int currLength=1;

                int nextNum  = num+1;
                while(map.containsKey(nextNum) && map.get(nextNum)==false){
                    currLength++;

                    map.put(nextNum,Boolean.TRUE);
                    nextNum++;
                }

                int prevNum  = num-1;
                while(map.containsKey(prevNum) && map.get(prevNum)==false){
                    currLength++;

                    map.put(prevNum,Boolean.TRUE);
                    prevNum--;
                }

                maxLength = Math.max(maxLength,currLength);

            }

            return maxLength;
        }
    }
}
