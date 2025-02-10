package dsa.problems.tree2;

//What is the Diameter of a Tree?
//The diameter of a tree is the longest path between any two nodes in the tree.
//The longest path may or may not pass through the root.
//        Formula for Diameter
//For a given node root, the diameter can be found as:
//
//diameter = leftSubtreeHeight + rightSubtreeHeight
//So, for every node, we calculate:
//Left Height: lh = height(root.left, dia)
//Right Height: rh = height(root.right, dia)
//Possible Diameter at this Node: lh + rh
public class DiameterOfBinaryTree {

    public int height(Node root, int[] dia) {
        if (root == null) {
            return 0; // Base case: height of null node is 0
        }

        int lh = height(root.left, dia);  // Left subtree height
        int rh = height(root.right, dia); // Right subtree height

        // Update the diameter if this node gives a longer path
        dia[0] = Math.max(dia[0], lh + rh);

        // Return height of this subtree
        return 1 + Math.max(lh, rh);
    }

    //
    class Solution {

        public int height(Node root, int[]dia){
            if(root==null){return 0;}
            int lh = height(root.left,dia);
            int rh = height(root.right,dia);
            dia[0]= Math.max(dia[0],lh+rh);
            return 1+ Math.max(lh,rh);
        }
        int diameter(Node root) {
            // Your code here
            int dia[] = new int[1];
            height(root,dia);
            return dia[0];
        }
    }

}
