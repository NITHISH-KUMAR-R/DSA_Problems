package dsa.problems.backTracking;

import java.util.*;

public class Permutations {
    class Solution {

        public void permute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] used) {
            if (ds.size() == nums.length) {
                ans.add(new ArrayList<>(ds));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // Skip used elements or duplicates
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }

                // Mark as used and add to the current permutation
                used[i] = true;
                ds.add(nums[i]);

                // Recur for the next elements
                permute(nums, ds, ans, used);

                // Backtrack
                ds.remove(ds.size() - 1);
                used[i] = false;
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums); // Sort to handle duplicates
            permute(nums, new ArrayList<>(), ans, new boolean[nums.length]);
            return ans;
        }
    }

}
