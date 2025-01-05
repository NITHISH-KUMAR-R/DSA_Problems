package dsa.problems.interview;

import java.util.Arrays;

public class CountPairs {
    class Solution {
        int countPairs(int arr[], int target) {
            // Your code here
            int count =0;

            int start = 0,  end = arr.length-1;
            Arrays.sort(arr);
            while(start<end){
                if(arr[start]+arr[end]<target){
                    count+= (end-start);
                    start++;

                }else {
                    end--;
                }
            }
            return count;


        }
    }
}
