package dsa.problems.interview;

public class CountTriplets {
    class Solution {
        public int countTriplets(int[] arr, int target) {
            int n = arr.length;
            int count = 0;

            for (int i = 0; i < arr.length ; i++) {
                int start = i + 1, end = arr.length - 1;

                while (start < end) {
                    int sum = arr[i] + arr[start] + arr[end];

                    if (sum == target) {
                        int s2 = arr[start], e2 = arr[end];
                        int c1 = 0, c2 = 0;

                        // Count occurrences of arr[start]
                        while (start <= end && arr[start] == s2) {
                            c1++;
                            start++;
                        }

                        // Count occurrences of arr[end]
                        while (start <= end && arr[end] == e2) {
                            c2++;
                            end--;
                        }

                        // Add the count of triplets
                        count += (s2 == e2) ? (c1 * (c1 - 1)) / 2 : (c1 * c2);
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }

            return count;
        }
    }
}
