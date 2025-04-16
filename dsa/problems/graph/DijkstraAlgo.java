package dsa.problems.graph;

import java.util.*;

public class DijkstraAlgo {
    class Solution {

        public static class GraphEdge {
            public int source;
            public int destination;
            public int weight;

            public GraphEdge(int s, int d, int w) {
                this.source = s;
                this.destination = d;
                this.weight = w;
            }

            public int getSource() {
                return this.source;
            }

            public int getDestination() {
                return this.destination;
            }

            public int getWeight() {
                return this.weight;
            }
        }

        public int[] dijkstra(int V, int[][] edges, int src) {
            int[] distance = new int[V];
            Arrays.fill(distance, Integer.MAX_VALUE);
            PriorityQueue<GraphEdge> pq = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

            Map<Integer, List<GraphEdge>> adjGraphMap = new HashMap<>();

            for (int i = 0; i < V; i++) {
                adjGraphMap.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                int source = edge[0];
                int destination = edge[1];
                int weight = edge[2];
                adjGraphMap.get(source).add(new GraphEdge(source, destination, weight));
                adjGraphMap.get(destination).add(new GraphEdge(destination, source, weight));
            }

            distance[src] = 0;
            pq.offer(new GraphEdge(src, src, 0));

            while (!pq.isEmpty()) {
                GraphEdge curr = pq.poll();
                int sourceNode = curr.getDestination();

                for (GraphEdge neighbor : adjGraphMap.get(sourceNode)) {
                    int destination = neighbor.getDestination();
                    int newDist = distance[sourceNode] + neighbor.getWeight();

                    if (newDist < distance[destination]) {
                        distance[destination] = newDist;
                        pq.offer(new GraphEdge(sourceNode,destination, newDist));
                    }
                }
            }

            return distance;
        }
    }

}
