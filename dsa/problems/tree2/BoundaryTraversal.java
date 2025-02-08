package dsa.problems.tree2;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {
    class Solution {
        public void leftBoundaryVisit(Node node, ArrayList<Integer> list){
            while(node!=null){
                if(node.left!=null || node.right!=null){
                    list.add(node.data);
                }
                node = (node.left!=null)?node.left : node.right;
            }
        }
        public void rightBoundaryVisit(Node node, ArrayList<Integer> list){
            Stack<Integer> st = new Stack<>();
            while(node!=null){
                if(node.left!=null || node.right!=null){
                    st.push(node.data);
                }
                node = (node.right!=null)?node.right : node.left;
            }
            while(!st.isEmpty()){
                list.add(st.pop());
            }
        }

        public void inorderVisitForLeafNode(Node node, ArrayList<Integer> list){
            if(node==null){return;}
            inorderVisitForLeafNode(node.left, list);
            if(node.left==null && node.right ==null){
                list.add(node.data);
            }
            inorderVisitForLeafNode(node.right,list);
        }

        ArrayList<Integer> boundaryTraversal(Node node) {
            // code here

            ArrayList<Integer> result  = new ArrayList<>();
            if(node == null) return result;

            result.add(node.data);
            leftBoundaryVisit(node.left, result);
            inorderVisitForLeafNode(node.left, result);
            inorderVisitForLeafNode(node.right, result);
            rightBoundaryVisit(node.right, result);

            return result;
        }
    }

}
