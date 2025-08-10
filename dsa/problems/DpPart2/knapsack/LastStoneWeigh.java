package dsa.problems.DpPart2.knapsack;

public class LastStoneWeigh {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length;
            int sum =0;
            for(int i : stones){
                sum +=i;
            }
            int target = sum /2;
            boolean dp[] = new boolean[target+1];
            dp[0]= true;
            for(int stone : stones){
                for(int j = target ;j>=stone;j--){
                    dp[j] = dp[j] || dp[j-stone];
                }
            }
            int maxPartition =0;
            for(int i =target;i>=0;i--){
                if(dp[i]){
                    maxPartition =i;
                    break;
                }
            }

            return sum - 2*maxPartition;
        }

}
