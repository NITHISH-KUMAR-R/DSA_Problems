package dsa.problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    class Solution {
        public int activitySelection(int[] start, int[] finish) {

            int n = start.length;
            int meetTime [][] = new int[n][2];

            for(int i =0;i<n;i++){
                meetTime[i][0]= start[i];
                meetTime[i][1]= finish[i];
            }


            Arrays.sort(meetTime , Comparator.comparingInt(a->a[1]));

            int lastEnd = meetTime[0][1];
            int count  =1;

            for(int i =0;i<n;i++){
                if(meetTime[i][0]>lastEnd){
                    lastEnd = meetTime[i][1];
                    count++;
                }
            }

            return count;


        }
    }
}
