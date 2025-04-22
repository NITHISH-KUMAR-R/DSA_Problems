package dsa.problems.greedy;

import java.util.Arrays;

public class MaximumLengthofPairChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {

            Arrays.sort(pairs,(a, b)-> a[1]-b[1]);

            int maxLength =0;
            int end = Integer.MIN_VALUE;

            for(int []pair : pairs){
                if(pair[0]>end){
                    maxLength++;
                    end = pair[1];
                }
            }
            return maxLength;
        }
    }
}

