package dsa.problems.graphstriver;

public class UnionFindRedudantConnection {
        public int find(int node){
            while(parent[node]!=node){
                node = parent[node];
            }
            return node;
        }
        public void union(int i , int  j){
            int iRoot = find(i);
            int jRoot = find(j);
            if(iRoot!=jRoot){
                parent[jRoot] = iRoot;
            }
        }
        int parent[];
        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            parent = new int[n+1];
            for(int i =0;i<=n;i++){
                parent[i] = i;
            }

            for(int edge[]: edges){
                if(find(edge[0])== find(edge[1])){
                    return edge;
                }
                union(edge[0], edge[1]);
            }

            return null;
        }

    }
