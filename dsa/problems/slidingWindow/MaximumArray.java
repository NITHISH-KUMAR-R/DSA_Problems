package dsa.problems.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumArray {
    class Solution {
        public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
            // code here

            ArrayList<Integer> result = new ArrayList<>();

            int n = arr.length;
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                // Remove elements from the front that are out of the window
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // Remove elements from the back that are smaller than the current element
                while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                    deque.pollLast();
                }

                // Add current element index at the end
                deque.offerLast(i);

                // Store the max value for the valid window (start storing when i >= k - 1)
                if (i >= k - 1) {
                    result.add(arr[deque.peekFirst()]);
                }
            }

            return result;


        }
    }
}


//K Sized Subarray Maximum