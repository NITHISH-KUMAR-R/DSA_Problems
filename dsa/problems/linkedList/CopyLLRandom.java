package dsa.problems.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyLLRandom {

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
//Copy List with Random Pointer -LeetCode
//Clone List with Next and Random - GFG

    class Solution {
        public Node copyRandomList(Node head) {

            Node curr = head;

            Map<Node,Node> map = new HashMap<>();

            while(curr!=null){
                Node newNode = new Node(curr.val);
                map.put(curr,newNode);
                curr = curr.next;
            }
            curr  = head;

            while(curr!=null){
                Node newNode = map.get(curr);
                newNode.next = map.get(curr.next);
                newNode.random  = map.get(curr.random);

                curr = curr.next;
            }
            return map.get(head);

        }
    }
}
