package dsa.problems.linkedList;

public class MerageTwoList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Solution class that contains the method to merge two lists
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode newList = new ListNode(-1); // Dummy node
            ListNode curr = newList; // Current pointer to build the new list

            // Traverse through both lists
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = list1; // Attach list1 node to merged list
                    list1 = list1.next; // Move to next node in list1
                } else {
                    curr.next = list2; // Attach list2 node to merged list
                    list2 = list2.next; // Move to next node in list2
                }
                curr = curr.next; // Move to next node in the merged list
            }

            // Attach remaining nodes from list1 or list2 if one list is exhausted
            curr.next = (list1 != null) ? list1 : list2;

            return newList.next; // Return merged list, skipping the dummy node
        }
    }

    public static void main(String[] args) {
        // Example of usage

        // Create first sorted list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Create second sorted list: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Merge the lists using the Solution class
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print merged list
        printList(mergedList); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
