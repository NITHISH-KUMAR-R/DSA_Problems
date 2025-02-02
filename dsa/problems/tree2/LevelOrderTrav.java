package dsa.problems.tree2;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class Solution {
        public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
            // Your code here

            Node temp = root;

            ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
            if(root==null){
                return list;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int levelSize = queue.size();
                ArrayList<Integer>  list2 = new ArrayList<>(levelSize);
                for(int i =0;i<levelSize;i++){
                    Node currNode = queue.poll();
                    list2.add(currNode.data);
                    if(currNode.left!=null){
                        queue.offer(currNode.left);
                    }
                    if(currNode.right!=null){
                        queue.offer(currNode.right);
                    }

                }
                list.add(list2);
            }
            return list;
        }
    }
}
