package dsa.problems.tree2;

public class HeightBinaryTree {

    //TC O(N) SP : O(N)
    class Solution {
        // Function to find the height of a binary tree.

        static int dfs(Node root){
            if(root==null) return -1;

            int left = dfs(root.left);
            int right = dfs(root.right);

            return Math.max(left,right)+1;

        }
        int height(Node node) {
            // code here

            return dfs(node);

        }
    }

}
