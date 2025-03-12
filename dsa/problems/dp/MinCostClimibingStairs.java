package dsa.problems.dp;

public class MinCostClimibingStairs {
    class Solution {
        static int minCostClimbingStairs(int[] cost) {
            // Write your code here
            // int n = cost.length;

            // int dp[] = new int[n];

            // if(n==0) return 0;
            // if(n==1) return cost[0];

            // dp[0] = cost[0];
            // dp[1] = cost[1];

            // for(int i =2;i<n;i++){
            //     dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
            // }

            // return Math.min(dp[n-1],dp[n-2]);


            int n= cost.length;

            int prev= cost[1];
            int prev2 = cost[0];

            for(int i =2;i<n;i++){
                int curr = cost[i] + Math.min(prev,prev2);
                prev2 = prev;
                prev= curr;

            }

            return Math.min(prev2,prev);
        }
    };
}
