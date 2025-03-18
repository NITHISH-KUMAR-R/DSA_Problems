package dsa.problems.dp;

public class SubsetPartial {
    class Solution {
        public static boolean   isSubSet(int arr[] , int sum){


            boolean dp [][] = new boolean[arr.length+1][sum+1];
            for(int i =0;i<arr.length;i++){
                dp[i][0] = true;
            }

            for(int i =1;i<=arr.length;i++){
                for(int j =1;j<=sum;j++){
                    if(arr[i-1]>j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j- arr[i-1]];
                    }
                }


            }
            return dp[arr.length][sum];
        }

        static boolean equalPartition(int arr[]) {
            // code here
            int sum =0;

            for(int i :arr ){
                sum+=i;
            }

            if(sum%2!=0) return false;

            return isSubSet(arr,sum/2);

        }
    }
}
