package dsa.problems.linkedList;

public class ReverseKgroupLL {
    class Solution {

        static Node reverse(Node head){
            Node curr = head;
            Node next = null;
            Node prev = null;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }
            return prev;
        }
        static Node findKthNode(Node head, int k){
            if(k<=0){return null;}
            Node curr = head;
            int count =1;
            while(curr!=null){
                if(count==k){
                    return curr;
                }
                curr = curr.next;
                count++;
            }
            return null;
        }

        public static Node reverseKGroup(Node head, int k) {
            Node curr = head, prev = null;

            while (curr != null) {

                Node kthNode = findKthNode(curr, k);

                if (kthNode == null) {
                    Node rev = reverse(curr);
                    if (prev != null) {
                        prev.next = rev;
                    } else {
                        return rev; // If first group is incomplete, return reversed head
                    }
                    break;
                }

                // Store the next group's starting point
                Node nextNode = kthNode.next;

                // Detach the group for reversal
                kthNode.next = null;

                // Reverse the group
                Node rhead = reverse(curr);

                // Connect the previous group to the reversed group
                if (curr == head) {
                    head = rhead; // Update head for the first group
                } else {
                    prev.next = rhead;
                }

                // Update prev to the last node of the reversed group
                prev = curr;

                // Move to the next group
                curr = nextNode;
            }

            return head;
        }
    }
}
