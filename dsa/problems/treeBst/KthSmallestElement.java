package dsa.problems.treeBst;


public class KthSmallestElement {
    class Solution {
        int ans = -1;
        int count =0;

        void help(Node root, int k){
            if(root ==null) return;
            if(count>=k) return;
            help(root.left,k);
            count = count+1;
            if(count == k){
                ans = root.data;
                return;

            }
            help(root.right,k);
        }
        // Return the Kth smallest element in the given BST
        public int kthSmallest(Node root, int k) {
            // Write your code here

            help(root,k);
            return ans;
        }

    }

    }