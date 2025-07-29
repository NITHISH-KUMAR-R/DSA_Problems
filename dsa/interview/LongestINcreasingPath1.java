package dsa.interview;

//This code iis we need to calculate that actula path value
public class LongestINcreasingPath1 {
    class Solution {

        public static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        public int dfs(int i, int j, int[][] mat, int[][] dp) {
            if (dp[i][j] != 0) return dp[i][j]; // already computed

            int maxSum = mat[i][j];  // start with the value of current cell
            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni >= 0 && nj >= 0 && ni < mat.length && nj < mat[0].length && mat[i][j] < mat[ni][nj]) {
                    maxSum = Math.max(maxSum, mat[i][j] + dfs(ni, nj, mat, dp));
                }
            }

            dp[i][j] = maxSum;
            return maxSum;
        }

        public int longestIncreasingPathSum(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int maxTotalSum = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maxTotalSum = Math.max(maxTotalSum, dfs(i, j, matrix, dp));
                }
            }

            return maxTotalSum;
        }
    }

}
