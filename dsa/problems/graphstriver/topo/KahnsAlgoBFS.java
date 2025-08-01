package dsa.problems.graphstriver.topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgoBFS {
    class Solution {

        public static ArrayList<Integer> topoSort(int V, int[][] edges) {
            // code here
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            int inDegree[] = new int[V];
            Queue<Integer> q = new LinkedList<>();
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v); // Directed edge u -> v
                inDegree[v]++;
            }
            for(int i =0;i<V;i++){
                if(inDegree[i]==0)
                    q.offer(i);
            }
            ArrayList<Integer> result = new ArrayList<>();
            while(!q.isEmpty()){
                int node = q.poll();
                result.add(node);

                for(int nei : adj.get(node)){
                    inDegree[nei]--;
                    if(inDegree[nei]==0){
                        q.offer(nei);
                    }
                }
            }



            return result;

        }
    }
}
