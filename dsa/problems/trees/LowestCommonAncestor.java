package dsa.problems.trees;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class LowestCommonAncestor {

    // Result class to hold both the LCA node and the depth of the deepest leaf
    static class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Call the DFS function to find the lowest common ancestor
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) return new Result(null, 0); // Base case for null node

        // Explore the left and right subtrees
        Result left = dfs(root.left);
        Result right = dfs(root.right);

        // Compare the depths of left and right subtrees
        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1); // LCA found
        } else if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else {
            return new Result(right.node, right.depth + 1);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor solution = new LowestCommonAncestor();

        // Test Case 1: Binary tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode result1 = solution.lcaDeepestLeaves(root1);
        System.out.println("LCA of deepest leaves (Test Case 1): " + result1.val); // Expected Output: 2

        // Test Case 2: Single Node tree
        TreeNode root2 = new TreeNode(1);
        TreeNode result2 = solution.lcaDeepestLeaves(root2);
        System.out.println("LCA of deepest leaves (Test Case 2): " + result2.val); // Expected Output: 1

        // Test Case 3: Tree with no left child
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        root3.right.left = new TreeNode(2);
        TreeNode result3 = solution.lcaDeepestLeaves(root3);
        System.out.println("LCA of deepest leaves (Test Case 3): " + result3.val); // Expected Output: 2
    }
}

