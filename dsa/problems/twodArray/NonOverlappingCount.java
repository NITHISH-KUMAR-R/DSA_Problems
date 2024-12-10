package dsa.problems.twodArray;

import java.util.Arrays;

public class NonOverlappingCount {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0; // Handle edge case: no intervals

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));

            int count =0;
            int lastIndex = intervals[0][1];
            for(int i =1;i<intervals.length;i++){
                if(intervals[i][0]<lastIndex){
                    count++;
                }else{
                    lastIndex = intervals[i][1];
                }
            }

            return count;

        }
    }
}
