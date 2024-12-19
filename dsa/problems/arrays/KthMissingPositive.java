package dsa.problems.arrays;

public class KthMissingPositive {
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            int exactValue =1;
            int i  =0;
            int count =0;
            while(true){
                if(i<arr.length && arr[i]==exactValue){
                    i++;
                }else{
                    count++;
                    if(count==k){
                        return exactValue;
                    }
                }
                exactValue++;
            }
        }
    }
}
