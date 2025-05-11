package dsa.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidataBst {

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
        public static void inOrder(TreeNode root, List<Integer> list){
            if(root==null) return;

            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
        public boolean isValidBST(TreeNode root) {

            List<Integer> list = new ArrayList<>();

            inOrder(root,list);


            boolean isBst = true;
            int prev = list.get(0);
            for(int i =1;i<list.size();i++){

                if(prev>=list.get(i)){
                    isBst = false;
                    break;
                }
                prev= list.get(i);
                isBst = true;
            }

            return isBst;

        }
    }
}
