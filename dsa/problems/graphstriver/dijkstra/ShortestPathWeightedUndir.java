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

