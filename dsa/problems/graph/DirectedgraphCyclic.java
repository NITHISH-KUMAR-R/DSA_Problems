package dsa.problems.graph;

import java.util.ArrayList;

public class DirectedgraphCyclic {
    class Solution {
        public static boolean dfs(int i,
                                  ArrayList<ArrayList<Integer>> adj, boolean[]visited,
                                  boolean[]pathVisited){

            visited[i]= true;
            pathVisited[i] = true;

            for(int neighbor : adj.get(i)){
                if(visited[neighbor]!=true){
                    if(dfs(neighbor,adj,visited,pathVisited)){
                        return true;
                    }
                }
                else if(pathVisited[neighbor]== true){
                    return true;
                }
            }

            pathVisited[i] = false;
            return false;


        }
        public boolean isCyclic(int V, int[][] edges) {
            // code here

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for(int i =0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int edge [] : edges){
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);
            }

            boolean[] visited = new boolean[V];
            boolean[] pathVisited = new boolean[V];

            for(int i =0;i<V;i++){
                if(visited[i]!= true){
                    if(dfs(i,adj,visited,pathVisited)){
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
