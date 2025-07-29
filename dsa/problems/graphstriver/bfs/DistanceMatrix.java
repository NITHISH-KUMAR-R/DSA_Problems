package dsa.problems.graphstriver.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceMatrix {
        // Function to find distance of nearest 1 in the grid for each cell.
        public int[][] nearest(int[][] grid) {
            // Code here

            Queue<int[]> q = new LinkedList<>();

            int m = grid.length;
            int n= grid[0].length;

            int mat[][] = new int[m][n];
            boolean [][] vis = new boolean[m][n];

            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    if(grid[i][j]==1){
                        mat[i][j] = 0;;
                        vis[i][j] = true;
                        q.offer(new int[]{i,j});
                    }
                }
            }
            int dir[][] ={{-1,0},{1,0},{0,-1},{0,1}};
            while(!q.isEmpty()){
                int arr[] = q.poll();
                int row =  arr[0];
                int col =  arr[1];

                for(int d[]: dir){
                    int nr = d[0]+row;
                    int nc = d[1]+col;
                    if(nr>=0 && nc >=0 && nr<m && nc<n && !vis[nr][nc]){
                        mat[nr][nc] = mat[row][col]+1;
                        q.offer(new int[]{nr,nc});
                        vis[nr][nc] = true;
                    }
                }

            }

            return mat;
        }

}
