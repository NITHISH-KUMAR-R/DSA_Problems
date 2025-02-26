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

//

class Solution2 {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int odd = 0, even = 1;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 !=0) {
                result = (result + even) % MOD;
                odd++;
            } else {
                result = (result + odd) % MOD;
                even++;
            }
        }

        return result;
    }
}
