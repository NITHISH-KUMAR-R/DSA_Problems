package dsa.problems.twodArray;

import java.util.ArrayList;
import java.util.List;

public class InsertNewInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            //  List<int[]> list = new ArrayList<>();

            //  List<int[]> reList = new ArrayList<>(Arrays.asList(intervals));
            //  reList.add(newInterval);

            //  reList.sort((a,b) -> Integer.compare(a[0],b[0]));

            //  for(int i =0;i<reList.size();i++){
            //     if(list.isEmpty()|| reList.get(i)[0] > list.get(list.size()-1)[1]){
            //         list.add(new int[]{reList.get(i)[0],reList.get(i)[1]});
            //     }else{
            //         list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],reList.get(i)[1]);
            //     }
            //  }

            //  return list.toArray(new int[list.size()][]);


            List<int[]> list = new ArrayList<>();

            int i =0;
            int n = intervals.length;

            while(i<n && intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
                i++;
            }

            while(i<n && intervals[i][0]<=newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
                i++;
            }
            list.add(newInterval);

            while(i<n){
                list.add(intervals[i]);
                i++;
            }
            return list.toArray(new int[list.size()][]);

        }
    }
}
