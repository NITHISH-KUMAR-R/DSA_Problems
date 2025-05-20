package dsa.problems.graphstriver;

import java.util.ArrayList;
import java.util.Stack;

class Toposort {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] vis) {
        vis[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, adj, st, vis); // ✅ fix: call dfs(neighbor)
            }
        }
        st.push(node);
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list (directed graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // ✅ Directed edge
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, st, vis);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }

        return list;
    }
}
