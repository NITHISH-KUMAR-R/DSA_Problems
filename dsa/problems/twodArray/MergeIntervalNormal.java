package dsa.problems.twodArray;

import java.util.Arrays;

public class MergeIntervalNormal {
   // import java.util.Arrays;

    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

            // Step 2: Use a temp array to store merged intervals
            int[][] temp = new int[intervals.length][2];
            int index = 0; // index for temp

            // First interval is always added
            temp[0] = intervals[0];

            for (int i = 1; i < intervals.length; i++) {
                int[] last = temp[index];       // last merged interval
                int[] current = intervals[i];   // current interval

                // If overlapping: merge
                if (current[0] <= last[1]) {
                    last[1] = Math.max(last[1], current[1]);
                } else {
                    index++;
                    temp[index] = current;
                }
            }

            // Step 3: Copy only the merged parts to result array
            int[][] result = new int[index + 1][2];
            for (int i = 0; i <= index; i++) {
                result[i] = temp[i];
            }

            return result;
        }
    }

}
