package dsa.problems.twodArray;

public class ProductPuzzle {
    class Solution {
        public static int[] productExceptSelf(int arr[]) {
            int n = arr.length;
            int prod = 1, cnt = 0;

            // Calculate product of non-zero elements and count zeros
            for (int x : arr) {
                if (x != 0) {
                    prod *= x;
                } else {
                    cnt++;
                }
            }

            int[] ans = new int[n]; // Initialize result array with zeros

            // Case 1: If more than one zero
            if (cnt >= 2) return ans;

            // Case 2: If exactly one zero
            if (cnt == 1) {
                for (int i = 0; i < n; i++) {
                    if (arr[i] == 0) {
                        ans[i] = prod; // Product only at the zero index
                        break;
                    }
                }
                return ans;
            }

            // Case 3: No zeros in the array
            for (int i = 0; i < n; i++) {
                ans[i] = prod / arr[i]; // Divide total product by the current element
            }

            return ans;
        }
    }
}
