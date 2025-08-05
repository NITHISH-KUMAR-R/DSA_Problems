package dsa.problems.graphstriver.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestBinaryMaze {
    // User function Template for Java


        int shortestPath(int[][] grid, int[] source, int[] destination) {

            // Your code here
            int srcX = source[0];
            int srcY = source[1];
            int destX = destination[0];
            int destY = destination[1];

            int m = grid.length;
            int n = grid[0].length;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2],b[2]));

            pq.offer(new int[]{srcX,srcY,0});

            int dist[][] = new int[m][n];
            for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

            dist[srcX][srcY] = 0;
            int dir[][] = {{-1,0},{0,1},{0,-1},{1,0}};
            while(!pq.isEmpty()){
                int arr[] = pq.poll();
                int x = arr[0],y = arr[1], dis = arr[2];
                if(x==destX && y==destY) return dis;

                if(dis>dist[x][y]) continue;

                for(int d[]: dir){
                    int nx = x+d[0];
                    int ny = y+d[1];

                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1){
                        if(dis+1 < dist[nx][ny]){
                            dist[nx][ny] = dis+1;
                            pq.offer(new int[]{nx,ny,dist[nx][ny]});
                        }
                    }
                }
            }
            return -1;
        }


}
