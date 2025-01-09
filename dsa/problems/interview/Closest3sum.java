package dsa.problems.interview;

import java.util.Arrays;

public class Closest3sum {


    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);  // Sort the array to apply two-pointer technique
            int closestSum = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length - 2; i++) {
                // Skip duplicates for the first element
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == target) {
                        return sum;  // Early exit if we find an exact match
                    }

                    // Update the closest sum
                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }

                    // Move pointers based on the sum
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return closestSum;
        }
    }

}
