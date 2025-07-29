//package dsa.problems.linkedList;
//
//public class InterviewProblem {
//
//    public ListNode reverse(ListNode head){
//        ListNode curr = head;
//        ListNode prev = null;
//        while(curr!=null){
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev= curr;
//            curr = temp;
//        }
//        return prev;
//    }
//    public ListNode findKGroupLastNode(ListNode head, int k){
//        int count =1;
//        ListNode kthNode   = head;
//        while(kthNode!=null && count !=k){
//            count++;
//            kthNode = kthNode.next;
//        }
//        return kthNode;
//    }
//
//    public  ListNode reverseKGroup (ListNode head, int k){
//        ListNode curr = head;
//        ListNode returnHead =null;
//        ListNode firstHead = head;
//        while(curr!=null) {
//            ListNode firstListEnd = head;
//            ListNode secondGroup = null;
//            firstListEnd = findKGroupLastNode(firstListEnd,k); //1 -> 2 -> 3 ->4 -> 5 ->6
//            secondGroup = firstListEnd.next; //4
//
//            firstListEnd.next = null; //1 2 3 - null
//            ListNode reverseFirstList = reverse(curr);
//            // 3 2 1-null
//            if(returnHead==null) {
//                 returnHead = reverseFirstList;
//            }//3 - return head;
//            ListNode reverseSecondGroup = reverse(secondGroup);
//            firstListEnd.next = reverseSecondGroup;
//            reverseSecondGroup.next = firstListEnd;
//
//        }
//
//        //returnHead -- 3/
//
//    }
//
//    public static void main(String []a){
//      //  List: 1 -> 2 -> 3 ->4 -> 5 ->6->7, k = 3
//        //reverse 3 2 1
//
//        //ListNode curr = Head
//
//        //
//        // - KthNode  - 3
//        //    SecondGroup  startingPoint = kthNode.next; //4
//        //     KthNode.next = null//  1 2 3 null
//        //  reverse group - // 3 2 1 null  - head 3 - storng return head;
//        //   second  - findKthlstNode =- 6
//        // reverese (startingPoint) - 6 5 4-
//        //Kthnode.next = second 6 - 1 2 3- 6 5 4
//        //
//        //
//
//    }
//}
