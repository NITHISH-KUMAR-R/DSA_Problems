package dsa.problems.MAANG;

public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {

            //    int n = nums.length;
            //     int sum = Arrays.stream(nums).filter(a -> a >= 0).sum();
            //   int value = n*(n+1)/2 - sum;

            //   return value;

            // int missingNumber=1;
            // Arrays.sort(nums);
            // for(int num : nums){
            //     if(num>0){
            //         if(num== missingNumber){
            //             missingNumber++;
            //         }else if( num>missingNumber){
            //             break;
            //         }
            //     }
            // }
            // return missingNumber;


            int n = nums.length;

            for(int i =0;i<n;i++){
                if(nums[i]<=0 || nums[i]>n){
                    nums[i] = n+1;
                }
            }

            for(int i =0;i<n;i++){
                int num= Math.abs(nums[i]);
                if(num<=n){
                    nums[num-1] = -Math.abs(nums[num-1]);
                }
            }

            for(int i =0;i<n;i++){
                if(nums[i]>0){
                    return i+1;
                }
            }
            return n+1;

        }
    }
}
