package dsa.problems.linkedList;

import java.util.HashSet;

public class RemoveLoop {
    class Solution {
        // Function to remove a loop in the linked list.
        public static void removeLoop(Node head) {
            // code here
            HashSet<Node> set = new HashSet<>();
            Node temp = head;

            while (temp != null) {
                // If the next node is already in the set, it means the loop starts there
                if (set.contains(temp.next)) {
                    temp.next = null; // Break the loop
                    break;
                }
                // Add the current node to the set and move to the next node
                set.add(temp);
                temp = temp.next;
            }
        }
    }
}
