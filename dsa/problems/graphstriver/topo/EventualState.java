package dsa.problems.graphstriver.topo;

import java.util.*;

public class EventualState {
        public List<Integer> eventualSafeNodes(int[][] graph) {

            List<List<Integer>> revAdj = new ArrayList<>();

            int n = graph.length;
            for(int i =0;i<n;i++){
                revAdj.add(new ArrayList<>());
            }
            int indegree[] = new int[graph.length];
            for(int u =0;u<graph.length;u++){
                for(int v : graph[u] ){
                    revAdj.get(v).add(u);
                    indegree[u]++;

                }
            }
            Queue<Integer> q  = new LinkedList<>();
            for(int i =0;i<graph.length;i++){
                if(indegree[i]==0){
                    q.offer(i);
                }
            }

            List<Integer> topo = new ArrayList<>();
            while(!q.isEmpty()){
                int node = q.poll();
                topo.add(node);
                for(int nei : revAdj.get(node)){
                    indegree[nei]--;
                    if(indegree[nei]==0){
                        q.offer(nei);
                    }
                }
            }

            Collections.sort(topo);
            return topo;
        }

}
