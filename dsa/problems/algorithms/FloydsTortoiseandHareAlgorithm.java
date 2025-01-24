package dsa.problems.algorithms;

public class FloydsTortoiseandHareAlgorithm {
 class ListNode {
      int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
      }
  }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false; // No cycle possible in an empty list or a single-node list
            }

            ListNode slow = head; // Slow pointer moves one step at a time
            ListNode fast = head; // Fast pointer moves two steps at a time

            while (fast != null && fast.next != null) {
                slow = slow.next; // Move slow pointer one step
                fast = fast.next.next; // Move fast pointer two steps

                if (slow == fast) { // If pointers meet, a cycle exists
                    return true;
                }
            }

            return false; // No cycle detected
        }
    }
}
