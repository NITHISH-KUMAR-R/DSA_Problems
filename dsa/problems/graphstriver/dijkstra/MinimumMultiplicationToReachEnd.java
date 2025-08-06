package dsa.problems.graphstriver.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {
    // User function Template for Java
     int minimumMultiplications(int[] arr, int start, int end) {
            // Your code here
            int mod = 100000;
            int[] dist = new int[mod];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            Queue<int[]> pq = new LinkedList<>();
            pq.offer(new int[]{start,0});


            while(!pq.isEmpty()){
                int curr[] = pq.poll();
                int target = curr[0];
                int steps = curr[1];
                if(end == target) return steps;

                for(int i : arr){
                    int v = (target * i)%mod;
                    if(steps+1 < dist[v]){
                        dist[v] = steps+1;
                        pq.offer(new int[]{v,steps+1});
                    }
                }


            }
            return -1;

        }
}

