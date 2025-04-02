package dsa.problems.graph;

import java.util.ArrayList;

public class DFS {
    class Solution {

        public static void dfsTraversal(int node,
                                        ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list , boolean[] visited){

            visited[node] = true;
            list.add(node);

            for(int val : adj.get(node)){
                if(visited[val]==false){
                    dfsTraversal(val,adj,list,visited);
                }
            }
        }
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
            // Code here

            boolean visited[] = new boolean[adj.size()+1];
            visited[0] = true;
            ArrayList<Integer> list  = new ArrayList<>();

            dfsTraversal(0,adj,list,visited);
            return list;

        }
    }
}
