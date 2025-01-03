package dsa.problems.twodArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatirx {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            int n =matrix.length;
            int m = matrix[0].length;
            int left =0,right =m-1;
            int top =0, bottom =n-1;
            List<Integer> list = new ArrayList<>();

            while(top<=bottom && left<=right){
                for(int i = left;i<=right;i++){
                    list.add(matrix[top][i]);
                }
                top++;
                for(int i = top;i<=bottom;i++){
                    list.add(matrix[i][right]);
                }
                right--;
                if(top<=bottom){
                    for(int i = right;i>=left;i--){
                        list.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                if(left<=right){
                    for(int i=bottom;i>=top;i--){
                        list.add(matrix[i][left]);
                    }
                    left++;
                }


            }

            return list;
        }
    }
}

//left , right, top , top++
//top bottom right , right --
// right , left , bottom , bottom --;
//bottom top , left , left --
