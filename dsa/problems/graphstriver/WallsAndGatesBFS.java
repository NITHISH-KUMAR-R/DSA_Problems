package dsa.problems.graphstriver;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesBFS {
        public void islandsAndTreasure(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            Queue<int[]> q = new LinkedList<>();

            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    if(grid[i][j]==0){
                        q.offer(new int[]{i,j});
                    }
                }
            }
            int dir [][] = {{-1,0},{1,0},{0,-1},{0,1}};
            while(!q.isEmpty()){
                int pos[] = q.poll();
                int row = pos[0];
                int col = pos[1];
                for(int d[] : dir){
                    int r = row+d[0];
                    int c = col+d[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==Integer.MAX_VALUE){
                        grid[r][c] = grid[row][col]+1;
                        q.offer(new int[]{r,c});
                    }
                }


            }

        }
    }

/// slands and Treasure
/// Solved
/// You are given a
/// m
/// ×
/// n
/// m×n 2D grid initialized with these three possible values:
///
/// -1 - A water cell that can not be traversed.
/// 0 - A treasure chest.
/// INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
/// Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.
///
/// Assume the grid can only be traversed up, down, left, or right.
///
/// Modify the grid in-place.
///
/// Example 1:
///
/// Input: [
///   [2147483647,-1,0,2147483647],
///   [2147483647,2147483647,2147483647,-1],
///   [2147483647,-1,2147483647,-1],
///   [0,-1,2147483647,2147483647]
/// ]
///
/// Output: [
///   [3,-1,0,1],
///   [2,2,1,-1],
///   [1,-1,2,-1],
///   [0,-1,3,4]
/// ]
/// Example 2:
///
/// Input: [
///   [0,-1],
///   [2147483647,2147483647]
/// ]
///
/// Output: [
///   [0,-1],
///   [1,2]
/// ]
/// Constraints:
///
/// m == grid.length
/// n == grid[i].length
/// 1 <= m, n <= 100
/// grid[i][j] is one of {-1, 0, 2147483647}
