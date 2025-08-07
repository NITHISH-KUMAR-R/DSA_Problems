package dsa.problems.graphstriver.bellman;

import java.util.Arrays;

public class Leetcode1334 {

        public int[] bellmanFord(int V, int edges[][], int src) {
            int dist[] = new int[V];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            for (int i = 0; i < V - 1; i++) {
                for (int e[] : edges) {
                    int u = e[0];
                    int v = e[1];
                    int w = e[2];
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                    if (dist[v] != Integer.MAX_VALUE && dist[v] + w < dist[u]) {
                        dist[u] = dist[v] + w;
                    }
                }
            }
            return dist;
        }

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {

            int minReachable = Integer.MAX_VALUE;
            int result = -1;
            for (int src = 0; src < n; src++) {
                int dist[] = bellmanFord(n, edges, src);
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (i != src && dist[i] <= distanceThreshold) {
                        count++;
                    }
                }

                if (count <= minReachable) {
                    minReachable = count;
                    result = src;
                }
            }

            return result;
        }
    }

