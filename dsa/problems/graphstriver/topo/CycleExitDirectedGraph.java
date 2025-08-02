package dsa.problems.graphstriver.topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleExitDirectedGraph {
        public boolean isCyclic(int V, int[][] edges) {
            // code here

            List<List<Integer>> adj = new ArrayList<>();

            for(int i =0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            int indegree[] = new int[V];
            for(int edge[] : edges){
                int u = edge[0];
                int v = edge[1];
                adj.get(v).add(u);
                indegree[u]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i =0;i<V;i++){
                if(indegree[i]==0){
                    q.offer(i);
                }
            }

            List<Integer> list = new ArrayList<>();

            while(!q.isEmpty()){
                int node = q.poll();

                list.add(node);

                for(int nei : adj.get(node)){
                    indegree[nei]--;
                    if(indegree[nei]==0){
                        q.offer(nei);
                    }
                }

            }

            return list.size()!=V?true:false;
        }
    }

