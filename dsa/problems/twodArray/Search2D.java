package dsa.problems.twodArray;

public class Search2D {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            int n = matrix.length;
            int m = matrix[0].length;
            int i = 0, j = m-1;

            while(i<n && j >=0){
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]>target){
                    j--;
                }else{
                    i++;
                }
            }
            return false;
        }



    }
}

class Solution {

    public boolean searchRowMatrix(int[][] mat, int x) {

        for(int i =0;i< mat.length;i++){
            int lo = 0, hi = mat[0].length-1;
            while(lo<=hi){
                int mid = (lo+hi)/2;
                if(mat[i][mid] == x)
                    return true;
                if(mat[i][mid] < x){
                    lo = mid +1;
                }
                else {
                    hi = mid-1;
                }
            }
        }
        return false;
    }
}


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // int n = matrix.length;
        // int m = matrix[0].length;
        // int i = 0, j = m-1;

        // while(i<n && j >=0){
        //     if(matrix[i][j]==target){
        //         return true;
        //     }else if(matrix[i][j]>target){
        //         j--;
        //     }else{
        //         i++;
        //     }
        // }
        // return false;

        for(int row[] : matrix){
            if( Arrays.binarySearch(row,target)>=0){
                return true;
            }
        }
        return false;
    }
}