package dsa.problems.tree2;

public class MirrorTreeGfg {
    class Solution {
        // Function to convert a binary tree into its mirror tree.
        void mirror(Node node) {
            // Your code here
            if(node ==null){
                return;
            }

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            mirror(node.right);
            mirror(node.left);
        }
    }
}
