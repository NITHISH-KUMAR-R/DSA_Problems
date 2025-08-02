package dsa.problems.graphstriver.topo;

import java.util.*;

public class ShortestPath {
        public int[] shortestPath(int V, int E, int[][] edges) {
            // Code here
            List<List<int[]>> adj  = new ArrayList<>();
            for(int i =0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            int indegree[] = new int[V];
            for(int edge [] : edges){
                int u  = edge[0];
                int v = edge[1];
                int wt = edge[2];

                adj.get(u).add(new int[]{v,wt});
                indegree[v]++;
            }
            Queue<Integer> q = new LinkedList<>();

            for(int i =0;i<V;i++){
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
            int dist[] = new int[V];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[0]=0;
            while(!q.isEmpty()){
                int u = q.poll();
                for(int edge[] : adj.get(u)){
                    int v = edge[0];
                    int wt = edge[1];
                    if(dist[u]!=Integer.MAX_VALUE && dist[v] > dist[u]+wt){
                        dist[v] = dist[u]+wt;
                    }
                    indegree[v]--;
                    if(indegree[v]==0){
                        q.offer(v);
                    }

                }

            }
            for(int i =0;i<V;i++){
                if(dist[i]==Integer.MAX_VALUE)
                    dist[i] = -1;
            }
            return dist;
        }
    }

