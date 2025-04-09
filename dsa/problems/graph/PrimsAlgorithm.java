package dsa.problems.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public static void main(String[] args) {

    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        boolean visited[] = new boolean[V];
        PriorityQueue<GraphEdge> pq = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));


        int totalWeight=0;
        for(int [] neighbor: adj.get(0)){
            pq.offer(new GraphEdge(0,neighbor[0],neighbor[1]));
        }
        visited[0] = true;

        while(!pq.isEmpty()){
            GraphEdge currGraph = pq.poll();
            int dest =currGraph.getDestination();
            if(visited[dest]==true) continue;
            visited[dest] = true;
            totalWeight += currGraph.getWeight();

            for(int [] neighbor:adj.get(dest)){
                if(visited[neighbor[0]]!=true){
                    pq.offer(new GraphEdge(dest,neighbor[0],neighbor[1]));
                }
            }
        }


        return totalWeight;
    }

}
