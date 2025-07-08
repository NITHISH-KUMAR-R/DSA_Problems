package dsa.interview;

public class GridTwoDirection {

        static int[][] grid;

        public static int maxPathSum(int row, int col, int m, int n) {
            // Out of bounds
            if (row < 0 || col >= n) return Integer.MAX_VALUE;

            // Reached destination
            if (row == 0 && col == n - 1) {
                return grid[row][col];
            }

            // Recursive call: move UP or RIGHT
            int moveUp = maxPathSum(row - 1, col, m, n);
            int moveRight = maxPathSum(row, col + 1, m, n);

            // Return max of the two + current cell value
            return grid[row][col] + Math.min(moveUp, moveRight);
        }

        public static void main(String[] args) {
            grid = new int[][] {
                    {5, 10, 20},
                    {4, 7, 6},
                    {2, 1, 8}
            };

            int m = grid.length;
            int n = grid[0].length;

            int result = maxPathSum(m - 1, 0, m, n);
            System.out.println("Maximum Path Sum: " + result);  // Expected: 49
        }
    }


