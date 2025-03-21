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
}
