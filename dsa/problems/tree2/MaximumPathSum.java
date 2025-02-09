package dsa.problems.tree2;

public class MaximumPathSum {
    class Solution {
        public int maxPathDown(Node node, int []max){
            if(node==null) return 0;
            int left = Math.max(0,maxPathDown(node.left,max));
            int right = Math.max(0,maxPathDown(node.right,max));

            max[0] = Math.max(max[0],left+right+node.data);
            return Math.max(left,right)+node.data;
        }
        // Function to return maximum path sum from any node in a tree.
        int findMaxSum(Node node) {
            // your code goes here
            int max [] = new int[1];
            max[0] = Integer.MIN_VALUE;
            maxPathDown(node,max);
            return max[0];
        }
    }
}
