package dsa.problems.twodArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            int n= intervals.length;
            List<int[]> list = new ArrayList<>();
            // Arrays.sort(intervals, new Comparator<int[]>(){
            //     public int compare(int a[], int b[]){
            //         return a[0]-b[0];
            //     }
            // });

            Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));


            for(int i =0;i<intervals.length;i++){
                if(list.isEmpty()|| intervals[i][0]>list.get(list.size()-1)[1]){
                    list.add(new int[]{intervals[i][0],intervals[i][1]});
                }else{
                    list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
                }
            }

            return list.toArray(new int[list.size()][]);

        }
    }

    class Solution2 {
        public List<int[]> mergeOverlap(int[][] arr) {
            // Code here // Code here

            List<int[]> list = new ArrayList<>();

            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));


            for(int i =0;i<arr.length;i++){
                if(list.isEmpty() || arr[i][0]>list.get(list.size()-1)[1]){
                    list.add(new int[]{arr[i][0], arr[i][1]});
                }else{
                    list.get(list.size()-1)[1] =Math.max(list.get(list.size()-1)[1],arr[i][1]);
                }
            }

            return list;
        }
    }
}
