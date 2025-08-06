package dsa.problems.graphstriver.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsKStops {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            for(int i =0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int f[] : flights){
                int u = f[0];
                int v = f[1];
                int w = f[2];
                adj.get(u).add(new int[]{v,w});
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(a[1],b[1]));
            pq.offer(new int[] {src,0,0});

            int dist[][] = new int[n][k+2];
            for (int[] d : dist)
                Arrays.fill(d, Integer.MAX_VALUE);

            while(!pq.isEmpty()){
                int arr[] = pq.poll();
                int node = arr[0];
                int cost = arr[1];
                int stops = arr[2];
                if(node==dst) return cost;
                if(stops<=k)
                    for(int nei [] : adj.get(node)){
                        int v = nei[0];
                        int currCost = nei[1];
                        int newCost = currCost + cost;
                        if(newCost < dist[v][stops+1]){
                            dist[v][stops+1] = newCost;
                            pq.offer(new int[]{v,newCost,stops+1});
                        }
                    }
            }
            return -1;

        }

}
