package dsa.problems.linkedList;

public class FistNodeInLoop {
    class Solution {
        //Leetcode Happy number also same logic
        public static Node findFirstNode(Node head) {
            // code here

            Node slow = head;
            Node fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow==fast){
                    slow = head;
                    while(slow!=fast){
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            return  null;

        }
    }

}

class Solution {
    //static int sum =0
    public static int getSquare(int n){
        int sum =0;
        while(n>0){
            int lDigit = n%10;
            sum+=lDigit*lDigit;
            n=n/10;
        }
        return  sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast =n;
        do{
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        }while(slow!=fast);

        return slow ==1;
    }
}
