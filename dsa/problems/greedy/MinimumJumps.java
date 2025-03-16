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
                if(i==curr){
                    jumps++;
                    curr = maxIndex;
                }
                if (curr >= arr.length - 1) {
                    return jumps;
                }
            }
            return -1;
        }
    }
}
