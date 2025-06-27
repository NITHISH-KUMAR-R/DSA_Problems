package dsa.interview;


public class OptimalPathDFSWithMemo {
    public static int optimalPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] memo = new Integer[m][n]; // memoization table
        return dfs(grid, m - 1, 0, memo, new boolean[m][n]);
    }
    private static int dfs(int[][] grid, int i, int j, Integer[][] memo, boolean[][]  visited) {
        int m = grid.length;
        int n = grid[0].length;
        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (visited[i][j]) return 0;
        // Base case: reached New_York (top-right)
        if (i == 0 && j == n - 1) return grid[i][j];
        // Return memoized result if exists
        visited[i][j] = true;
        // Explore north and east
        int up = dfs(grid, i - 1, j, memo,visited);
        int right = dfs(grid, i, j + 1, memo,visited);
        int left = dfs(grid, i, j - 1, memo,visited);
        int down = dfs(grid,i+1,j,memo,visited);
        visited[i][j] = false;

        // Store result in memo and return
        return grid[i][j] + Math.max(Math.max(up, right),  Math.max(left,down));

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };

        int result = optimalPath(grid);
        System.out.println("👉 Final Result: " + result); // Output: 10
    }
}
