package dsa.interview;

//Length of longest increasing path in matrix
public class LongestIncreasingPath {
    class Solution {

        public static int dir[][] ={{-1,0},{1,0},{0,-1},{0,1}};

        public int dfs(int i , int j , int dp[][] ,int mat [][]){

            if(dp[i][j]!=0){
                return dp[i][j];
            }
            int max =1;
            for(int d[]: dir){
                int nr = d[0]+i;
                int nc = d[1]+j;

                if(nr>=0 && nc>=0 && nr <mat.length && nc<mat[0].length && mat[i][j]<mat[nr][nc]){
                    max = Math.max(max , 1+ dfs(nr,nc,dp,mat));
                }
            }

            dp[i][j] = max;
            return max;
        }
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int maxLength =0;
            int dp [][] = new int[m][n];
            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    maxLength = Math.max(maxLength, dfs(i, j , dp,matrix));
                }
            }

            return maxLength;

        }
    }
}
