package dsa.problems.twodArray;

public class FindMissingandRepated {
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int size = n*n;
            boolean [] found = new boolean[size+1];
            int repeat =-1;
            int missing =-1;

            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                    int num = grid[i][j];
                    if(found[num]){
                        repeat = num;
                    }
                    found[num] = true;
                }
            }

            for(int i =1;i<=size;i++){
                if(!found[i]){
                    missing = i;
                }
            }

            return new int[]{repeat, missing};
        }
    }
}

//2965. Find Missing and Repeated Values
//Find the repeating and missing numbers:
//If present[num] is already true, it's the repeating number.
//If any index i remains false, it's the missing number.