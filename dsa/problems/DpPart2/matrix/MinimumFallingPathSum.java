package dsa.problems.DpPart2.matrix;

public class MinimumFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;

            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    int down = matrix[i + 1][j];
                    int downLeft = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                    int downRight = (j < n - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;
                    matrix[i][j] += Math.min(down, Math.min(downLeft, downRight));
                }
            }

            int result = Integer.MAX_VALUE;
            for (int val : matrix[0]) {
                result = Math.min(val, result);
            }

            return result;

        }
    }
}
