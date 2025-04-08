package dsa.problems.graph;

public class MainClassForWeightedGraph {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addDirectedEdge(1, 2, 5);
        graph.addDirectedEdge(2, 1, 9);
        graph.addDirectedEdge(2, 4, 3);
        graph.addDirectedEdge(4, 1, 8);
        graph.addDirectedEdge(3, 2, 6);
        System.out.println(graph);
    }
}
