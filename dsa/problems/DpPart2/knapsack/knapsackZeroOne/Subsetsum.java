package dsa.problems.DpPart2.knapsack.knapsackZeroOne;

public class Subsetsum {
    public static boolean subSet(int arr[], int target){

        int n = arr.length;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i =0;i<n;i++){
            dp[i][0] = true;
        }

        for(int i =1;i<=n;i++){
            for(int j = 1;j<=target;j++){
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][target];
    }

    public static boolean subsetSum(int arr[], int target){
        boolean dp[] = new boolean[target+1];
        dp[0] = true;
        for(int num: arr){
            for(int j =target;j>=num;j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }


        return dp[target];

    }
    public static void main(String a[]){
        int arr[]  = {2,3,5,2,7};
        System.out.println("Subset Sum Problem");
        System.out.println("2dArray: "+subSet(arr,7));
        System.out.println("1d Array:  "+subsetSum(arr,7));
    }
}
