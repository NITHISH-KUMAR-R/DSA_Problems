package dsa.problems.SlidingWinTwoPoint;

import java.util.HashSet;
import java.util.Set;

class TwoSumGfg {
    boolean twoSum(int arr[], int target) {
        // code here

        Set<Integer> set = new HashSet<>();
        for(int i =0;i<arr.length;i++){

            int comp = target - arr[i];
            if(set.contains(comp)){
                return true;
            }
            set.add(arr[i]);

        }

        return false;
    }
}
