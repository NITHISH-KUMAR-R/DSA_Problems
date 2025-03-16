package dsa.problems.greedy;

public class MinimumJumps {
    class Solution {
        static int minJumps(int[] arr) {
            // your code here
            int jumps =0;
            int curr =0;
            int maxIndex =0;

            for(int i =0;i<arr.length;i++){

                maxIndex = Math.max(maxIndex,arr[i]+i);
                if (i == curr) {
                    //we can ignore these two if block as well
                    if (curr >= arr.length - 1) return jumps; // If we reached the last index, return the number of jumps taken.
                    if (curr == maxIndex) return -1; // If we are stuck and can't move further, return -1.
                    jumps++; // Increase jump count as we need a new jump to move forward.
                    curr = maxIndex; // Update the current boundary to the farthest reachable index.
                }

                if (curr >= arr.length - 1) {
                    return jumps;
                }
            }
            return -1;
        }
    }
}
