package dsa.problems.recursionpractice;

import java.util.Arrays;

public class NumericPadDp {

        // Directions: stay, up, down, left, right
        static int[][] directions = {
                {0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        static int[][][] memo;

        public static int dfs(int i, int j, char[][] grid, int n) {
            if (i < 0 || j < 0 || i >= 4 || j >= 3 || grid[i][j] == '*' || grid[i][j] == '#')
                return 0;

            if (n == 1)
                return 1;

            if (memo[i][j][n] != -1)
                return memo[i][j][n];

            int count = 0;
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                count += dfs(ni, nj, grid, n - 1);
            }

            return memo[i][j][n] = count;
        }

        public int getCount(int n) {
            char[][] grid = {
                    {'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'},
                    {'*', '0', '#'}
            };

            memo = new int[4][3][n + 1];
            for (int[][] layer : memo)
                for (int[] row : layer)
                    Arrays.fill(row, -1);

            int total = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] != '*' && grid[i][j] != '#') {
                        total += dfs(i, j, grid, n);
                    }
                }
            }
            return total;
        }

        public static void main(String[] args) {
            NumericPadDp s = new NumericPadDp();
            System.out.println("n = 1 → " + s.getCount(1));  // 10
            System.out.println("n = 2 → " + s.getCount(2));  // 36
            System.out.println("n = 3 → " + s.getCount(3));  // 138
            System.out.println("n = 4 → " + s.getCount(4));  // 532
            System.out.println("n = 10 → " + s.getCount(10)); // fast result
        }


}
