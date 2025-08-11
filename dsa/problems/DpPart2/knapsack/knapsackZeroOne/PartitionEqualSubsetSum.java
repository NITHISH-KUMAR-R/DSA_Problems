package dsa.problems.DpPart2.knapsack.knapsackZeroOne;

public class PartitionEqualSubsetSum {
        public boolean canPartition(int[] nums) {
            int n = nums.length;

            int totalSum =0;
            for(int i : nums){
                totalSum +=i;
            }
            if(totalSum%2!=0) return false;

            totalSum = totalSum/2;

            boolean dp[] = new boolean[totalSum+1];
            dp[0] = true;
            for(int num :nums){
                for(int j = totalSum ;j>=num;j--){
                    dp[j] = dp[j] || dp[j-num];
                }
            }
            return dp[totalSum];


        }
    }

