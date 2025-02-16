package dsa.problems.treeBst;


import java.util.ArrayList;
import java.util.List;

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
    class Solution2 {
        public int kthSmallest(Node root, int k) {
            List<Integer> inorderList = new ArrayList<>();
            inorderTraversal(root, inorderList);

            // If k is larger than the number of nodes, return -1
            if (k > inorderList.size() || k <= 0) return -1;

            return inorderList.get(k - 1);  // k-th smallest element (1-based index)
        }

        void inorderTraversal(Node root, List<Integer> list) {
            if (root == null) return;

            inorderTraversal(root.left, list);
            list.add(root.data);
            inorderTraversal(root.right, list);
        }
    }

    }