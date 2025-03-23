package dsa.problems.dp;

public class HouseRobber3 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public int[] robTravel(TreeNode root) {
            if (root == null) {
                return new int[2];
            }


            int[] leftRob = robTravel(root.left);
            int[] rightRob = robTravel(root.right);
            int options[] = new int[2];

            options[0] = root.val + leftRob[1] + rightRob[1];

            options[1] = Math.max(leftRob[0], leftRob[1]) + Math.max(rightRob[0], rightRob[1]);


            return options;


        }

        public int rob(TreeNode root) {

            int options[] = robTravel(root);

            return Math.max(options[0], options[1]);

        }
    }
}
