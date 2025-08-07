package dsa.problems.graphstriver.bellman;

import java.util.Arrays;

public class BellmanFordAlgo {
        public int[] bellmanFord(int V, int[][] edges, int src) {
            // code here

            int dist[] = new int[V];
            Arrays.fill(dist,(int)1e8);
            dist[src]=0;
            for(int i =0;i<V-1;i++){
                for(int e [] :edges){
                    int u = e[0];
                    int v = e[1];
                    int w = e[2];

                    if(dist[u]!=(int)1e8 && dist[u]+w<dist[v]){
                        dist[v] = dist[u]+w;
                    }

                }
            }

            for(int e [] :edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if(dist[u]!=(int)1e8 && dist[u]+w<dist[v]){
                    return new int[]{-1};
                }

            }

            return dist;

        }
    }


