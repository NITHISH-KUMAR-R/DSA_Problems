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

            public int getSource() { return source; }
            public int getDestination() { return destination; }
            public int getWeight() { return weight; }
        }
        private int manhattanDist(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        public int minCostConnectPoints(int[][] points) {
            int n =points.length;

            PriorityQueue<GraphEdge> pq = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
            int totalWeight =0;
            int edgesUsed =0;
            boolean  visited[] = new boolean[n];
            visited[0] = true;

            for(int i=1;i<n;i++){
                int weight = manhattanDist(points[0],points[i]);
                pq.offer(new GraphEdge(0,i,weight));
            }

            while(!pq.isEmpty()){
                GraphEdge graph = pq.poll();
                int dest = graph.getDestination();
                if(visited[dest]==true) continue;
                visited[dest]= true;
                totalWeight += graph.getWeight();

                for(int i =0;i<n;i++){
                    if(visited[i]!=true){
                        int weight = manhattanDist(points[dest], points[i]);
                        pq.offer(new GraphEdge(dest,i,weight));
                    }
                }

            }

            return totalWeight;
        }
    }
}
