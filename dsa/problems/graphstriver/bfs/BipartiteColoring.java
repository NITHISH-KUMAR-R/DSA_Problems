package dsa.problems.graphstriver.bfs;

import java.util.ArrayList;
import java.util.List;

public class BipartiteColoring {
    class Solution {

        public boolean bfs( List<Integer>[] mat , int start, int color[] ){
            Queue<Integer> q= new LinkedList<>();
            q.offer(start);
            color[start]=1;

            while(!q.isEmpty()){
                int node = q.poll();
                for(int neighbor : mat[node]){
                    if(color[neighbor]==0){
                        color[neighbor] = -color[node];
                        q.offer(neighbor);
                    }
                    else if(color[node]==color[neighbor]){
                        return false;
                    }
                }
            }

            return true;
        }
        public boolean isBipartite(int V, int[][] edges) {
            List<Integer>[] graph = new ArrayList[V];
            for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            int color[] = new int[V];
            for(int i =0;i<V;i++){
                if(color[i]==0 && !bfs(graph, i,color)){
                    return false;
                }
            }

            return true;


        }
    }
}
