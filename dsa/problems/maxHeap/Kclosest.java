package dsa.problems.minHeap.maxHeap;

import java.util.PriorityQueue;

public class Kclosest {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            // Your code here

            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->{
                return Integer.compare((b[1]*b[1] + b[0]*b[0]) ,(a[0]*a[0] + a[1]*a[1]));
            });

            for(int [] result : points){
                heap.offer(result);
                if(heap.size()>k){
                    heap.poll();
                }
            }

            int [][]  ans = new int[k][2];
            for(int i =0;i<k;i++){
                ans[i] = heap.poll();

            }

            return ans;

        }
    }
}
