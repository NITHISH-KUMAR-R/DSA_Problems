package dsa.problems.twopointers;

import java.util.ArrayList;

public class SubarraySumK {
    //gfg problem
    class Solution {
        static ArrayList<Integer> subarraySum(int[] arr, int target) {
            // code here
            //Arrays.sort(arr);
            int left =0;

            ArrayList<Integer> list = new ArrayList<>();

            int currSum =0;
            for(int right =0;right<arr.length;right++){
                currSum+=arr[right];
                while(currSum>target && left<right){
                    currSum -= arr[left];
                    left++;
                }
                if(currSum==target){
                    list.add(left+1);
                    list.add(right+1);
                    return list;
                }
            }
            list.add(-1);
            return list;

        }
    }
}
