package dsa.problems.graphstriver.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NoofWaysToDestination {
        public int countPaths(int n, int[][] roads) {

            List<List<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] r : roads) {
                int u = r[0], v = r[1], w = r[2];
                adj.get(u).add(new int[]{v, w});
                adj.get(v).add(new int[]{u, w});
            }

            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;

            int[] ways = new int[n];
            ways[0] = 1;

            int mod = 1_000_000_007;

            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
            pq.offer(new long[]{0, 0}); // {node, time}

            while (!pq.isEmpty()) {
                long[] arr = pq.poll();
                int node = (int) arr[0];
                long time = arr[1];

                if (time > dist[node]) continue;

                for (int[] nei : adj.get(node)) {
                    int v = nei[0];
                    long newTime = time + nei[1];

                    if (newTime < dist[v]) {
                        dist[v] = newTime;
                        ways[v] = ways[node];
                        pq.offer(new long[]{v, newTime});
                    } else if (newTime == dist[v]) {
                        ways[v] = (ways[v] + ways[node]) % mod;
                    }
                }
            }

            return ways[n - 1];
        }

}
