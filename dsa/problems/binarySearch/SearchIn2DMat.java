package dsa.problems.binarySearch;

//74. Search a 2D Matrix
public class SearchIn2DMat {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int left =0;
            int right = m*n-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                int row = mid/n;
                int col = mid%n;
                if(matrix[row][col]==target) return true;
                if(matrix[row][col]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            return false;

        }
    }

