package dsa.problems.graph;

public class GraphEdge {
    public final int source;
    public final int destination;
    public final int weight;

    public GraphEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return source + " -> " + destination + " (weight " + weight + ")";
    }
}
