package dsa.problems.graphstriver.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumEffort {
        public int minimumEffortPath(int[][] heights) {



            int m = heights.length, n = heights[0].length;
            int[][] dist = new int[m][n];
            for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
            dist[0][0] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2],b[2]));
            pq.offer(new int[]{0,0,0});
            int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
            while(!pq.isEmpty()){
                int arr[] = pq.poll();
                int x = arr[0];
                int y = arr[1];
                int dis = arr[2];
                if(x == m-1 && y==n-1) return dis;
                if(dis > dist[x][y]) continue;
                for(int d [] : dir){
                    int nx = x+ d[0];
                    int ny = y+d[1];
                    if(nx >=0 && ny >=0 && nx<m && ny <n){
                        int newEffort = Math.max(dis, Math.abs(heights[x][y] - heights[nx][ny]));
                        if (newEffort < dist[nx][ny]) {
                            dist[nx][ny] = newEffort;
                            pq.offer(new int[]{nx, ny, newEffort});
                        }
                    }
                }

            }

            return 0;
        }

}
