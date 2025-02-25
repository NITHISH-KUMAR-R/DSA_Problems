package dsa.problems.arrays;

public class SubarrayOddSumCount {
    class Solution {
        public int numOfSubarrays(int[] arr) {
            int MOD = 1000000007;
            long oddCount =0 ,evenCount=1;
            long prefixSum =0;
            long result =0;
            for(int num:arr){
                prefixSum += num;
                if(prefixSum%2!=0){
                    result +=evenCount;
                    oddCount++;
                }else{
                    result +=oddCount;
                    evenCount++;
                }
                result %= MOD;
            }

            return (int) result;
        }
    }
}
