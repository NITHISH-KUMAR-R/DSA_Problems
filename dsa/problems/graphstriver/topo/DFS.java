package dsa.problems.graphstriver.topo;

import java.util.*;

public class DFS {
        public static void dfs(int i , List<Integer>[] adj , Set<Integer> set, Stack<Integer> st){
            set.add(i);
            for(int nei : adj[i]){
                if(!set.contains(nei)){
                    dfs(nei,adj,set,st) ;
                }
            }

            st.push(i);
        }
        public static ArrayList<Integer> topoSort(int V, int[][] edges) {
            // code here
            //List<List<Integer>> adj = new ArrayList<>();
            // for (int i = 0; i < V; i++) {
            //     adj.add(new ArrayList<>());
            // }
            // for (int[] edge : edges) {
            //     int u = edge[0];
            //     int v = edge[1];
            //     adj.get(u).add(v); // Directed edge u -> v
            // }
            List<Integer>[] adj = new ArrayList[V];

            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<>();

            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                // graph[edge[1]].add(edge[0]);
            }
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> st = new Stack<>();
            for(int i =0;i<V;i++){
                if(!visited.contains(i)){
                    dfs(i,adj,visited,st);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            while(!st.isEmpty()){
                result.add(st.pop());
            }

            return result;

        }
    }

