package dsa.problems.twodArray;

public class Rotate90Degree {
    class CLockWise {

        public void rotate(int[][] matrix) {

            int n = matrix.length;
            //This is Transpose Matrix
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            //Reverse Each row
            for (int i = 0; i < n; i++) {
                for (int j = 0, k = n - 1; j < k; j++, k--) {
                    int temp = matrix[i][k];
                    matrix[i][k] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }


        class Anticlockwise {
            // Function to rotate matrix anticlockwise by 90 degrees.
            static void rotateby90(int mat[][]) {
                // code here

                //int[][] arr= new int[arr.length][arr[0].length];

                int n = mat.length;

                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = temp;
                    }
                }
                //reverse Each column
                for (int i = 0; i < n; i++) {
                    for (int j = 0, k = n - 1; j < k; j++, k--) {
                        int temp = mat[j][i];
                        mat[j][i] = mat[k][i];
                        mat[k][i] = temp;
                    }
                }

            }
        }
    }
}


//Hint Clockwise - reverse each row after transpose - i,k, i,j
//Hint anticlockwise - reverse each column after transpose k,i  j,i