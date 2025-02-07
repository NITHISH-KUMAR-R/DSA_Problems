package dsa.problems.tree2;

import java.util.ArrayList;

public class Inorder {
    class Solution {
        // Function to return a list containing the inorder traversal of the tree.

        public static void dfs(Node root, ArrayList<Integer> list){
            if(root==null){
                return;
            }
            //list.add(node);
            dfs(root.left,list);
            list.add(root.data);
            dfs(root.right,list);
        }

        ArrayList<Integer> inOrder(Node root) {

            ArrayList<Integer> list = new ArrayList<>();
            dfs(root,list);
            return list;


        }
    }
}
