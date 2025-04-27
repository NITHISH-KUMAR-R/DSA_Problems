package dsa.problems.trickProblems;

public class MajorityElementvotes {
    class Solution {
        static int majorityElement(int arr[]) {
            // code here
            int num = arr[0];
            int votes =1;

            for(int i =1;i<arr.length;i++){
                if(votes==0){
                    num = arr[i];
                    votes++;
                }else if(num==arr[i]){
                    votes++;
                }else{
                    votes--;
                }
            }
            // Optional verification step
            int count = 0;
            for (int val : arr) {
                if (val == num) count++;
            }
            if (count > arr.length / 2) {
                return num;
            }

            return -1; // No majority element found
            //return num;

        }
    }
}
