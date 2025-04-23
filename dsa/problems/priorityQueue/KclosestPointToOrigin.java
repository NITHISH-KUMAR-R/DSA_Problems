package dsa.problems.priorityQueue;

import java.util.PriorityQueue;

public class KclosestPointToOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->((b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])));

            for(int []point : points){
                pq.offer(point);
                while(pq.size()>k){
                    pq.poll();
                }
            }


            int res[][] = new int[pq.size()][2];
            int count =0;
            while(!pq.isEmpty()){
                res[count++] = pq.poll();
            }
            return res;

        }
    }
}
