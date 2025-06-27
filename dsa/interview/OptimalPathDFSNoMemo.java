package dsa.interview;

public class OptimalPathDFSNoMemo {
    public static int optimalPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return dfs(grid, m - 1, 0);
    }

    private static int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j >= n) {
            return 0;
        }
        if (i == 0 && j == n - 1) {
            return grid[i][j];
        }

        int goNorth = dfs(grid, i - 1, j);
        int goEast = dfs(grid, i, j + 1);

        int result = grid[i][j] + Math.max(goNorth, goEast);
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };

        int result = optimalPath(grid);
        System.out.println("\n👉 Final Result: " + result);
    }
}
