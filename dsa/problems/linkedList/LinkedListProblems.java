package dsa.problems.linkedList;

public class LinkedListProblems {

    class Reverse {
        Node reverseList(Node head) {
            // code here
            Node curr = head;
            Node prev = null;
            Node next = null;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;

        }
    }
}
