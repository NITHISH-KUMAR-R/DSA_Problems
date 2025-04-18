package dsa.problems.DpPart2.one1dDp;

public class SolvingQuestionwithBrainPower {
    //2140. Solving Questions With Brainpower
    class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long dp[] = new long[n+1];

            for(int i =n-1;i>=0;i--){
                int points = questions[i][0];
                int skip = questions[i][1];
                int nextIndex =i+skip+1;

                long takeIt = points + (nextIndex < n ? dp[nextIndex]:0);

                long skipIt = dp[i+1];
                dp[i]=Math.max(takeIt, skipIt);
            }

            return dp[0];
        }
    }
}
