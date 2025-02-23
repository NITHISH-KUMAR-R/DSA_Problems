package dsa.problems.tree2;

public class ConstructTreePostOrderPreOrder {
    class Solution {
        private int preIndex = 0;
        private int postIndex =0;
        public Node constructFromPrePost(int[] preorder, int[] postorder) {
            Node curr = new Node(preorder[preIndex]);
            preIndex++;

            if(curr.data!= postorder[postIndex]){
                curr.left =constructFromPrePost(preorder,postorder);

            }
            if(curr.data!= postorder[postIndex]){
                curr.right =constructFromPrePost(preorder,postorder);

            }

            postIndex++;
            return curr;
        }
    }
}
