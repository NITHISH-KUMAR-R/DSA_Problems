package dsa.problems.DpPart2.lis;

public class LongestIncrArithmeticSequence {
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int n =nums.length;
            int dp[][] = new int[n][1001];
            int maxLength =0;

            for(int i =0;i<n;i++){
                for(int j =0;j<i;j++){
                    int diff = nums[i] -nums[j]+500;
                    dp[i][diff] = dp[j][diff]+1;
                    maxLength = Math.max(dp[i][diff],maxLength);
                }
            }
            return maxLength+1;
        }
    }
}
