package dsa.problems.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {
    class Solution {
        public int countTriplets(int[] arr, int target) {
            int n = arr.length;
            int count = 0;

            for (int i = 0; i < n - 2; i++) {
                int p1 = i+1;
                int p2 = n - 1;

                while (p1 < p2) {
                    int sum = arr[i] + arr[p1] + arr[p2];

                    if (sum == target) {
                        count++;
                        int tp1 = p1+1;
                        int tp2 = p2-1;
                        while (tp1<p2 && arr[tp1] == arr[p1]){ count++;tp1++;}
                        while (tp2>p1 && arr[tp2] == arr[p2]){ count++;tp2--;}
                        p1++;
                        p2--;

                    } else if (sum < target) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }

            return count;
        }
    }
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list  = new ArrayList<>();
            for(int i =0;i<nums.length-1;i++){
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int start =i+1;
                int end =nums.length-1;
                while(start<end){
                    int sum = nums[i]+nums[start]+nums[end];
                    if(sum==0){

                        list.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) {start++;}
                        while (start < end && nums[end] == nums[end - 1]) { end--; }
                        start++;
                        end--;

                    }else if(sum<0){
                        start++;

                    }else{
                        end--;
                    }
                }   }
            return list;
        }
    }
}
