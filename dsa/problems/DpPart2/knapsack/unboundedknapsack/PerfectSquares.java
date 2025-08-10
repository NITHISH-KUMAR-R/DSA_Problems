package dsa.problems.DpPart2.knapsack.unboundedknapsack;

import java.util.Arrays;

public class PerfectSquares {
        public int numSquares(int n) {

            int dp[] = new int[n+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] =0;
            for(int i =1;i*i <=n;i++){
                int square = i*i;
                for(int j =square ;j<=n;j++){
                    dp[j] = Math.min(dp[j] , dp[j-square]+1);
                }
            }

            return dp[n];

        }
    }

