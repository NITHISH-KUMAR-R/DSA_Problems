package dsa.problems.trickProblems;

public class UniqueNumbeIII {
    class Solution {
        public int getSingle(int[] arr) {
            // code here

            int ones = 0 , twos =0;

            for(int num : arr){
                ones =( ones ^ num) & ~twos;
                twos = (twos ^ num) & ~ones;
            }

            return ones;

        }
    }
}
