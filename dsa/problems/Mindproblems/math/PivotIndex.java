package dsa.problems.Mindproblems.math;

public class PivotIndex {
    class Solution {
        // Function to find equilibrium point in the array.
        public static int findEquilibrium(int arr[]) {


            int left = 0;
            int total = 0;
            for (int i : arr) {
                total += i;
            }
            for (int i = 0; i < arr.length; i++) {
                if (left == (total - left - arr[i]))
                    return i;
                left += arr[i];
            }
            return -1;

        }
    }
}
