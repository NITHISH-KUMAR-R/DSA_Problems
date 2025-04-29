package dsa.problems.linkedList;

public class SortLinkedList {

    class Solution {

        static Node segregate(Node head) {
            // code here

            //Node curr = head;

            Node oneDummy = new Node(-1);
            Node zeroDummy = new Node(-1);
            Node twoDummy = new Node(-1);

            Node one = oneDummy;
            Node two = twoDummy;
            Node zero = zeroDummy;

            Node curr = head;
            while(curr!=null){
                if(curr.data==0){
                    zero.next = curr;
                    zero = zero.next;
                }
                else if(curr.data==1){
                    one.next = curr;
                    one = one.next;
                }else{
                    two.next = curr;
                    two = two.next;
                }
                curr = curr.next;
            }

            zero.next = (oneDummy.next!=null) ? oneDummy.next : twoDummy.next;
            one.next = twoDummy.next;
            two.next=null;

            return zeroDummy.next;

        }
    }

    //Approch 2
    class Solution2 {
        static Node segregate(Node head) {


            Node temp = head;
            int colorCount[] = new int[3];
            while(temp!=null){
                colorCount[temp.data]++;
                temp = temp.next;
            }

            temp = head;
            int i =0;

            while(temp!=null){
                if(colorCount[i]==0){
                    i++;
                }else{
                    temp.data= i;
                    colorCount[i]--;
                    temp= temp.next;
                }
            }

            return head;

        }
    }


}
