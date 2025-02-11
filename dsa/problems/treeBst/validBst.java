package dsa.problems.treeBst;


public class validBst {

    class Solution {
        boolean checkValidBst(TreeNode root,int min, int max){
            if(root == null) return true;

            if(root.val <= min || root.val>=max){
                return false;
            }

            return checkValidBst(root.left,min, root.val) && checkValidBst(root.right,root.val,max);
        }
        public boolean isValidBST(TreeNode root) {

            return checkValidBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

        }
    }
}
