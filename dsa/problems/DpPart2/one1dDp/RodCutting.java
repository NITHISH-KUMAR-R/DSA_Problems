package dsa.problems.DpPart2.one1dDp;

public class RodCutting {
    class Solution {
        public int cutRod(int[] price) {
            // code here
            int n = price.length;
            int dp[] = new int [price.length+1];
            int maxValue =0;

            for(int i =1;i<=n;i++){
                for(int j =0;j<i;j++){
                    maxValue = Math.max(maxValue, price[j]+dp[i-j-1]);
                }
                dp[i]= maxValue;
            }

            return maxValue;
        }
    }
}
