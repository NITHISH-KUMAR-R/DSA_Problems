package dsa.problems.treeBst;

public class SwapTwoNodesBST {
    class Solution {
        Node first =null , second =null, prev= null;
        void check(Node root){
            if(root==null){
                return;
            }
            check(root.left);
            if(prev!=null && prev.data>root.data){
                if(first==null){
                    first = prev;
                }
                second = root;
            }
            prev = root;
            check(root.right);
        }
        void correctBST(Node root) {
            // code here.
            check(root);

            if (first != null && second != null) {
                int temp = first.data;
                first.data = second.data;
                second.data = temp;
            }
        }
    }
}
