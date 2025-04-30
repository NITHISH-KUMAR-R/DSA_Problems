package dsa.problems.linkedList;

public class FindLoopandCount {
    class Solution {
        public static int countNode(Node curr){
            Node meetingPoint = curr;
            int count =1;
            while(curr.next!=meetingPoint){
                count++;
                curr= curr.next;
            }
            return count;
        }
        // Function to find the length of a loop in the linked list.
        public int countNodesinLoop(Node head) {
            // code here.

            Node slow = head;
            Node fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow==fast){
                    return countNode(slow);
                }

            }

            return 0;
        }
    }
}
