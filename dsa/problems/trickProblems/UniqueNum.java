package dsa.problems.trickProblems;

public class UniqueNum {
    class Solution {
        public int findUnique(int[] arr) {
            // code here
            int n =0;
            for(int num : arr){
                n ^=num;
            }
            return n;

        }
    }
}
