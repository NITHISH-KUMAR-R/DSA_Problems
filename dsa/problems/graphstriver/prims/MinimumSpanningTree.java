package dsa.problems.graphstriver.prims;

import java.util.*;

public class MinimumSpanningTree {
    public int spanningTree(int V, int[][] edges) {
        // code here
        Set<Integer> set = new HashSet<>();
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});

        int sum = 0;
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int node = curr[0];
            int wt = curr[1];

            if (set.contains(node)) continue;
            set.add(node);
            sum += wt;

            for (int nei[] : adj.get(node)) {
                int v = nei[0];
                int w = nei[1];
                if (!set.contains(v)) {
                    pq.offer(new int[]{v, w});
                }
            }

        }


        return sum;


    }
}


