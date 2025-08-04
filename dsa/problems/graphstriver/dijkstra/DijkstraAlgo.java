package dsa.problems.graphstriver.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
        public int[] dijkstra(int V, int[][] edges, int src) {
            // code here
            List<List<int[]>> adj = new ArrayList<>();
            for(int i =0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int edge [] : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                adj.get(u).add(new int[]{v,w});
                adj.get(v).add(new int[]{u,w});
            }
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

            pq.offer(new int[]{src,0});

            while(!pq.isEmpty()){
                int [] arr = pq.poll();
                int node  = arr[0];
                int d = arr[1];
                if(d > dist[node]) continue;
                for(int neighbor[] : adj.get(node)){
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    if(dist[node] + weight < dist[nextNode]){
                        dist[nextNode] = dist[node]+weight;
                        pq.offer(new int[]{nextNode, dist[nextNode]});
                    }

                }
            }

            return dist;
        }
    }

