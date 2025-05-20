package dsa.problems.graphstriver;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

        public static boolean dfs(int node, List<List<Integer>> adj , int vis[] ){
            vis[node] = 1;

            for(int neighbor : adj.get(node)){
                if(vis[neighbor] == 1) return true;
                if(vis[neighbor] == 0 && dfs(neighbor,adj,vis)) return true;
            }
            vis[node]=2;
            return false;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adj = new ArrayList<>(0);

            for(int i = 0;i<numCourses;i++){
                adj.add(new ArrayList<Integer>());
            }

            for(int edges[] :prerequisites ){
                int u  = edges[0];
                int v = edges[1];
                adj.get(v).add(u);
            }

            int[] visited = new int[numCourses];

            for(int i =0;i<numCourses;i++){
                if(visited[i]==0){
                    if( dfs(i, adj, visited)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
