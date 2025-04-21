package dsa.problems.DpPart2.fibonocciStyle;

public class DeletandEarn {
    class Solution {
        //same pattern followed like house robber problem
        public int deleteAndEarn(int[] nums) {
            int max =0;
            for(int num : nums){
                max = Math.max(num,max);
            }

            int  housePoints []=  new int [max+1];
            for(int num: nums){
                housePoints[num] +=num;
            }

            int dp[] = new int[max+1];
            dp[0]=0;
            dp[1]= housePoints[1];

            for(int i =2;i<=max;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+housePoints[i]);
            }
            return dp[max];

        }
    }
}
