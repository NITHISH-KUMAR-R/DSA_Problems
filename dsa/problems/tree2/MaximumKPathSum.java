package dsa.problems.tree2;

import java.util.HashMap;
import java.util.Map;

public class MaximumKPathSum {
    class Solution {
        public int helper(Node root, int curr, Map<Integer,Integer> map, int k){
            if(root==null) return 0;
            curr += root.data;

            int path = map.getOrDefault(curr-k,0);

            map.put(curr, map.getOrDefault(curr,0)+1);

            path += helper(root.left,curr,map,k);

            path += helper(root.right, curr, map,k);

            map.put(curr, map.get(curr)-1);

            return path;

        }
        public int sumK(Node root, int k) {
            // code here

            Map<Integer,Integer> map = new HashMap<>(c);
            map.put(0,1);
            return helper(root,0,map,k);
        }
    }
}
