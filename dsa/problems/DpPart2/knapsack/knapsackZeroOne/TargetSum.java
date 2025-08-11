package dsa.problems.DpPart2.knapsack.knapsackZeroOne;

public class TargetSum {
        public int subset(int arr[],int sum ){
            int n = arr.length;
            int dp[][] = new int[n+1][sum+1];
            for(int i =0;i<=n;i++){
                dp[i][0] = 1;
            }
            for(int i =1;i<=n;i++){
                for(int j =0;j<=sum;j++){
                    if(arr[i-1]>j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                    }
                }
            }
            return dp[n][sum];
        }

        public int subSetSum(int nums[], int target){

            int dp[]=  new int[target+1];
            dp[0]=1;
            for(int num : nums){
                for(int j =target ;j>=num;j--){
                    dp[j] = dp[j] + dp[j-num];
                }
            }

            return dp[target];
        }
        public int findTargetSumWays(int[] nums, int target) {
            int totalSum  =0;
            for(int i : nums){
                totalSum +=i;
            }

            if((totalSum+target)%2!=0 || totalSum<Math.abs(target)){
                return 0;
            }

            target = (totalSum+target)/2;
            return subSetSum(nums,target);
        }
    }

