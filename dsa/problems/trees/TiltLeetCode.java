package dsa.problems.trees;

import javax.swing.tree.TreeNode;

public class TiltLeetCode {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int total =0;
        public int calculate(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = calculate(root.left);
            int right = calculate(root.right);

            int max = Math.abs(left-right);
            total+=max;

            return root.valc+left+right;
        }
        public int findTilt(TreeNode root) {
            calculate(root);
            return total;

        }
    }
}
