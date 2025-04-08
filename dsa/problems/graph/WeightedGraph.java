package dsa.problems.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    int vertices;
    private List<GraphEdge>[] adjList;

    public WeightedGraph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            adjList[i] = new ArrayList<>();
        }
    }

    public void addDirectedEdge(int s, int d, int w){
        GraphEdge edge = new GraphEdge(s, d, w);
        adjList[s].add(edge);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vertices; i++) {
            sb.append("Vertex ").append(i).append(": ");
            for(GraphEdge edge : adjList[i]) {
                sb.append(edge.toString()).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
