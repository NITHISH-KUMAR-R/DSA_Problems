package dsa.problems.algorithms;

import java.util.HashSet;

public class JavaUnion {
    class Solution {
        public static int findUnion(int a[], int b[]) {
            // code here
            HashSet<Integer> unionSet = new HashSet<>();

            // Add all elements of array 'a' to the set
            for (int num : a) {
                unionSet.add(num);
            }

            // Add all elements of array 'b' to the set
            for (int num : b) {
                unionSet.add(num);
            }

            // The size of the set is the count of elements in the union
            return unionSet.size();

        }
    }
}
