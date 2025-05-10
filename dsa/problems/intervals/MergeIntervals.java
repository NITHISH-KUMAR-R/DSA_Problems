package dsa.problems.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

            int prevInterval [] = intervals[0];
            List<int[]> list = new ArrayList<>();
            list.add(prevInterval);

            for(int []interval: intervals){
                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(prevInterval[1],interval[1]);
                }else{
                    prevInterval = interval;
                    list.add(prevInterval);

                }
            }

            return list.toArray(new int[list.size()][]);

        }
    }
}

