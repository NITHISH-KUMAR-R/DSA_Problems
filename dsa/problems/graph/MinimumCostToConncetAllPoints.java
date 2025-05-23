package dsa.problems.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConncetAllPoints {
    class Solution {
        static class GraphEdge {
            private final int source;
            private final int destination;
            private final int weight;

            public GraphEdge(int source, int destination, int weight) {
                this.source = source;
                this.destination = destination;
                this.weight = weight;
            }

            public int getSource() {
                return source;
            }

            public int getDestination() {
                return destination;
            }

            public int getWeight() {
                return weight;
            }
        }

        private int manhattanDist(int[] p1, int[] p2) {

            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        public int minCostConnectPoints(int[][] points) {
            int n = points.length;

            PriorityQueue<GraphEdge> pq = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
            int totalWeight = 0;
            //int edgesUsed =0;
            boolean visited[] = new boolean[n];
            visited[0] = true;

            for (int destination = 0; destination < n; destination++) {
                int weight = manhattanDist(points[0], points[destination]);
                pq.offer(new GraphEdge(0, destination, weight));
            }

            while (!pq.isEmpty()) {
                GraphEdge graph = pq.poll();
                int source = graph.getDestination();
                if (visited[source] == true) continue;
                visited[source] = true;
                totalWeight += graph.getWeight();

                for (int destination = 0; destination < n; destination++) {
                    if (visited[destination] != true) {
                        int weight = manhattanDist(points[source], points[destination]);
                        pq.offer(new GraphEdge(source, destination, weight));
                    }
                }

            }

            return totalWeight;
        }
    }


}
