package dsa.problems.graph;

public class FloodFillGfg {
    class Solution {

        public void dfs(int i, int j, int[][] image, int originalColor, int newColor) {
            // Base condition
            if (i < 0 || i >= image.length || j < 0 || j >= image[0].length ||
                    image[i][j] != originalColor) {
                return;
            }

            // Change the color
            image[i][j] = newColor;

            // Visit 4 directions
            dfs(i - 1, j, image, originalColor, newColor);
            dfs(i + 1, j, image, originalColor, newColor);
            dfs(i, j - 1, image, originalColor, newColor);
            dfs(i, j + 1, image, originalColor, newColor);
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int originalColor = image[sr][sc];

            // If the color is already the same, no need to fill
            if (originalColor == newColor) {
                return image;
            }

            dfs(sr, sc, image, originalColor, newColor);
            return image;
        }
    }
}
