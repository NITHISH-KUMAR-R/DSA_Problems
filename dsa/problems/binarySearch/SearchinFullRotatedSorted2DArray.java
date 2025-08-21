package dsa.problems.binarySearch;

public class SearchinFullRotatedSorted2DArray {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            int midVal = mat[row][col];

            if (midVal == x) return true;
            int lowVal = mat[low / n][low % n];
            int highVal = mat[high / n][high % n];
            if (lowVal <= midVal) {
                if (lowVal <= x && x < midVal) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }

            } else {
                if (midVal < x && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return false;


    }
}
