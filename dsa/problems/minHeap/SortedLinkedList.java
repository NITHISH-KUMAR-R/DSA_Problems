package dsa.problems.minHeap;



import dsa.problems.linkedList.Node;

import java.util.List;
import java.util.PriorityQueue;

public class SortedLinkedList {
    class Solution {
        // Function to merge K sorted linked list.
        Node mergeKLists(List<Node> arr) {
            // Add your code here.
            Node head = new Node(0);
            Node res = head;

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.data-b.data);

            for(Node a : arr){
                pq.offer(a);
            }
            while(!pq.isEmpty()){
                Node minNode = pq.poll();
                head.next = new Node(minNode.data);
                head = head.next;

                if(minNode.next!=null){
                    pq.offer(minNode.next);
                }

            }

            return res.next;
        }
    }
}
