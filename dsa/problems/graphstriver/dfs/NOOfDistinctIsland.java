package dsa.problems.graphstriver.dfs;

import java.util.HashSet;
import java.util.Set;

public class NOOfDistinctIsland {
    class Solution {
        public static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};

        public static void dfs(int i ,int j , int baseI, int baseJ,int mat[][], StringBuilder sb){
            if(i<0 || j<0  || i>=mat.length  || j >= mat[0].length || mat[i][j]!=1) return;
            mat[i][j] = -1;
            sb.append((i-baseI) + "_" + (j-baseJ) +",");
            for(int d[] : dir){
                dfs(i+d[0] , j+d[1], baseI , baseJ, mat, sb);
            }
        }
        int countDistinctIslands(int[][] grid) {
            Set<String> set = new HashSet<>();

            int m = grid.length;
            int n = grid[0].length;

            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    if(grid[i][j]==1){
                        StringBuilder sb = new StringBuilder();
                        dfs(i,j,i,j,grid,sb);
                        set.add(sb.toString());
                    }
                }
            }

            return set.size();
        }
    }

}
