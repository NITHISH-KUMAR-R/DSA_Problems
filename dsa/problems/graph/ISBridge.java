package dsa.problems.graph;

import java.util.ArrayList;

public class ISBridge {
    class Solution {
        public static int countComponents(ArrayList<ArrayList<Integer>> adj , boolean[] visited, int V){
            int count =0;
            for(int i =0;i<V;i++){
                if(visited[i]!=true){
                    dfs(i,adj,visited);
                    count++;
                }

            }
            return count;
        }

        public static void dfs(int i ,ArrayList<ArrayList<Integer>> adj, boolean[]visited){
            visited[i]= true;
            for(int neighbor : adj.get(i)){
                if(visited[neighbor]!=true){
                    dfs(neighbor,adj,visited);
                }

            }
        }
        public boolean isBridge(int V, int[][] edges, int c, int d) {
            // code here

            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

            for(int i =0;i<V;i++){
                adjList.add(new ArrayList<>());
            }//This creates AdjList to store connections

            for(int []edge : edges){
                int u = edge[0];
                int v = edge[1];
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            boolean [] visited = new boolean[V];
            int count  = countComponents(adjList, visited, V);

            adjList.get(c).remove((Integer)d);
            adjList.get(d).remove((Integer)c);

            boolean [] visited2 = new boolean[V];
            int count2  = countComponents(adjList, visited2, V);

            return count2>count;

        }
    }
}
