package dsa.problems.graphstriver.topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adj = new ArrayList<>();
            for(int i =0;i<numCourses;i++){
                adj.add(new ArrayList<>());
            }
            Queue<Integer> q = new LinkedList<>();
            int topo [] = new int[numCourses];
            int inDegree[] = new int [numCourses];
            for(int p []: prerequisites){
                int u = p[0];
                int v = p[1];
                adj.get(v).add(u);
                inDegree[u]++;
            }

            for(int i =0;i<inDegree.length;i++){
                if(inDegree[i]==0) q.offer(i);
            }
            int i =0;

            while(!q.isEmpty()){
                int node = q.poll();

                topo[i++]= node;

                for(int neighbor: adj.get(node)){
                    inDegree[neighbor]--;
                    if(inDegree[neighbor]==0) q.offer(neighbor);
                }
            }

            if(i==numCourses) return topo;
            else return new int[0];
        }

}
