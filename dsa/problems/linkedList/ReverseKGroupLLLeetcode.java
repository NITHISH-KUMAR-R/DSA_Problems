package dsa.problems.linkedList;

public class ReverseKGroupLLLeetcode {
    class Solution {
        ListNode reverse(ListNode head){
            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        ListNode findKthNode(ListNode head, int k){
            ListNode curr = head;
            int count =1;
            while(curr!=null){
                if(count == k){
                    return curr;
                }
                curr = curr.next;
                count++;
            }
            return null;
        }
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            ListNode prev = null;

            while(curr!=null){
                ListNode kthNode = findKthNode(curr,k);
                if(kthNode == null){
                    if(prev!=null){
                        prev.next = curr;
                    }
                    break;
                }

                ListNode nextNode = kthNode.next;
                kthNode.next = null;
                reverse(curr);
                if(head == curr){
                    head = kthNode;
                }else{
                    prev.next = kthNode;
                }
                prev = curr;
                curr = nextNode;
            }
            return head;
        }
    }
}
