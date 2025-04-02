package dsa.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // User function Template for Java
    class Solution {
        // Function to return Breadth First Search Traversal of given graph.
        public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            // code here\

            ArrayList<Integer> list = new ArrayList<>();

            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[adj.size()+1];
            visited[0] = true;

            q.add(0);

            while(!q.isEmpty()){
                Integer node = q.poll();
                list.add(node);

                for(Integer a : adj.get(node)){
                    if(visited[a]==false){
                        visited[a]= true;
                        q.add(a);
                    }
                }
            }

            return list;


        }
    }
}
