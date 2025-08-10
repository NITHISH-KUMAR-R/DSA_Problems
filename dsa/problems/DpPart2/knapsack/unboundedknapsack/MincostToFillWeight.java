package dsa.problems.DpPart2.knapsack.unboundedknapsack;

import java.util.Arrays;

public class MincostToFillWeight {

        public static int minimumCost(int n, int w, int[] cost) {
            // code here
            int INF = (int) 1e9;
            int dp[]=  new int[w+1];
            Arrays.fill(dp,INF);
            dp[0] =0;// Base: 0 kg needs 0 cost

            for(int i =1;i<=n;i++){//packet
                if(cost[i-1]==-1) continue;
                for(int j =i;j<=w;j++){//weight
                    dp[j] = Math.min(dp[j],dp[j-i]+cost[i-1]);
                }
            }

            return dp[w] ==INF ? -1 : dp[w];

        }
    }

