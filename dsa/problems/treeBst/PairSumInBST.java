package dsa.problems.treeBst;

import java.util.ArrayList;

public class PairSumInBST {
    class Solution {
        public void inOrderTraversal (Node root , ArrayList<Integer> list){
            if(root==null) return;
            inOrderTraversal(root.left, list);
            if(root!=null){
                list.add(root.data);

            }

            inOrderTraversal(root.right, list);
        }

        //234789
        boolean findTarget(Node root, int target) {

            ArrayList<Integer> list = new ArrayList<>();
            inOrderTraversal(root,list);
            int left = 0; int right = list.size()-1;


            while(left<right){
                int sum = list.get(left) + list.get(right);

                if(sum==target){
                    return true;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    left++;
                }

            }
            return false;
        }
    }
}
