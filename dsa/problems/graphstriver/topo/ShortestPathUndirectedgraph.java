package dsa.problems.graphstriver.topo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedgraph {
        public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {

            int n = adj.size();
            int dist[] = new int[n];
            Arrays.fill(dist,-1);

            Queue<Integer> q = new LinkedList<>();
            q.offer(src);
            dist[src]=0;

            while(!q.isEmpty()){
                int node = q.poll();
                for(int nei : adj.get(node)){
                    if(dist[nei]==-1){
                        dist[nei] = dist[node]+1;
                        q.offer(nei);
                    }
                }
            }

            return dist;
        }

}
