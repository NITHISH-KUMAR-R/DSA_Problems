package dsa.problems.dp;

public class HouseRobber1 {
    class Solution {
        public int findMaxSum(int arr[]) {
            // code here
            int n = arr.length;
            if(arr.length<2){
                return 0;
            }
            int dp[] = new int[arr.length];

            dp[0] = arr[0];
            dp[1] = Math.max(arr[0],arr[1]);

            for(int i =2;i<arr.length;i++){
                dp[i] = Math.max(dp[i-2]+arr[i],dp[i-1]);
            }

            return dp[arr.length-1];
        }
    }

    class Solution2 {
        public int findMaxSum(int arr[]) {
            int n = arr.length;
            if (n == 0) return 0;
            if (n == 1) return arr[0];

            int prev2 = 0, prev1 = arr[0];

            for (int i = 1; i < n; i++) {
                int curr = Math.max(prev2 + arr[i], prev1);
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }
    }

}
