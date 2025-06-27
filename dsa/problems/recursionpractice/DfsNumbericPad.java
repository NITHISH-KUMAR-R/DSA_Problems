package dsa.problems.recursionpractice;

public class DfsNumbericPad {
        // Directions: stay, up, down, left, right
        static int[][] directions = {
                {0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        public static int dfs(int i, int j, char[][] grid, int n) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
                return 0;
            if (grid[i][j] == '*' || grid[i][j] == '#')
                return 0;
            // Base case: only 1 digit remaining
            if (n == 1)
                return 1;
            int count = 0;
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                count += dfs(ni, nj, grid, n - 1);
            }
            return count;
        }
        public int getCount(int n) {
            char[][] grid = {
                    {'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'},
                    {'*', '0', '#'}
            };

            int rowLen = grid.length;
            int colLen = grid[0].length;
            int count = 0;

            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (grid[i][j] != '*' && grid[i][j] != '#') {
                        count += dfs(i, j, grid, n);
                    }
                }
            }

            return count;
        }
        // For testing
        public static void main(String[] args) {
            DfsNumbericPad s = new DfsNumbericPad();
            //System.out.println("n = 1 → " + s.getCount(1)); // Should be 10


            System.out.println("n = 2 → " + s.getCount(2)); // Should be 36
            //System.out.println("n = 3 → " + s.getCount(3)); // Should be 138
        }

}
