package dsa.problems.DpPart2.matrix;

public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n  = matrix[0].length;
            int dp[][] = new int [m][n];
            int result = 0;
            // First row and column need special handling
            for (int i = 0; i < m; i++) {
                dp[i][0] = matrix[i][0] - '0';
                result = Math.max(result, dp[i][0]);
            }

            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j] - '0';
                result = Math.max(result, dp[0][j]);
            }


            // Fill rest of the DP table
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1 + Math.min(
                                dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1])
                        );
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }

            return result * result; // Return area

        }
    }

    class Solution2GFG {
        static int maxSquare(int mat[][]) {
            // code here
            int m = mat.length;
            int n = mat[0].length;

            int dp [][] = new int [m][n];
            int result = 0;
            for(int i =0;i<m;i++){
                dp[i][0] = mat[i][0];
                result = Math.max(result,dp[i][0]);
            }
            for(int i =0;i<n;i++){
                dp[0][i] = mat[0][i];
                result = Math.max(result,dp[0][i]);
            }

            for(int i =1;i<m;i++){
                for(int j =1;j<n;j++){
                    if(mat[i][j]==1){
                        dp[i][j] =1+ Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                        result = Math.max(dp[i][j],result);

                    }

                }
            }

            return result;
        }
    }
}
