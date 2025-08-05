package dsa.problems.graphstriver.dijkstra;

import java.util.*;

public class ShortestPathWeightedUndir {
        public List<Integer> shortestPath(int n, int m, int edges[][]) {
            //  Code Here.
            List<List<int[]>> adj = new ArrayList<>();
            for(int i =0;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            for(int edge[] : edges){
                int u = edge[0];
                int v= edge[1];
                int w = edge[2];
                adj.get(u).add(new int[]{v,w});
                adj.get(v).add(new int[]{u,w});
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            pq.offer(new int[]{1,0});
            int dist[]  = new int[n+1];
            int parent[] = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            for(int i =0;i<=n;i++){
                parent[i] = i;
            }
            dist[1]=0;
            while(!pq.isEmpty()){
                int arr [] = pq.poll();
                int node  = arr[0];
                int d = arr[1];
                if(d>dist[node]) continue;

                for(int nei[] : adj.get(node)){
                    int nextNode  = nei[0];
                    int weight = nei[1];
                    if(dist[node]+weight < dist[nextNode]){
                        dist[nextNode] = dist[node]+weight;
                        pq.offer(new int[]{nextNode, dist[nextNode]});
                        parent[nextNode] = node;
                    }
                }
            }
            List<Integer> path = new ArrayList<>();
            if (dist[n] == Integer.MAX_VALUE) {
                path.add(-1);
                return path;
            }

            // Backtrack the path
            int node = n;
            while (parent[node] != node) {
                path.add(node);
                node = parent[node];
            }
            path.add(1);
            Collections.reverse(path);
            path.add(0, dist[n]);

            return path;
        }
    }
    //Shortest Path in Weighted undirected graph
//Difficulty: MediumAccuracy: 50.0%Submissions: 82K+Points: 4Average Time: 20m
//You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along with their weights. Find the shortest weight path between the vertex 1 and the vertex n,  if there exists a path, and return a list of integers whose first element is the weight of the path, and the rest consist of the nodes on that path. If no path exists, then return a list containing a single element -1.
//
//The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.
//
//Note: The driver code here will first check if the weight of the path returned is equal to the sum of the weights along the nodes on that path, if equal it will output the weight of the path, else -2. In case the list contains only a single element (-1) it will simply output -1.
//
//Examples :