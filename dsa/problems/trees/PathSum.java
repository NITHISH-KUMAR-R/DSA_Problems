package dsa.problems.trees;

import java.util.Stack;

public class PathSum {
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;

            Stack<TreeNode> path = new Stack<>();
            Stack<Integer> sum = new Stack<>();

            path.push(root);
            sum.push(root.val);

            while(!path.isEmpty()){
                TreeNode node = path.pop();
                int sumValue = sum.pop();

                if(sumValue==targetSum && node.left == null && node.right==null){
                    return true;
                }

                if(node.left!=null){
                    path.push(node.left);
                    sum.push(sumValue+ node.left.val);
                }
                if(node.right!=null){
                    path.push(node.right);
                    sum.push(sumValue+ node.right.val);
                }
            }
            return false;
        }
    }
}
