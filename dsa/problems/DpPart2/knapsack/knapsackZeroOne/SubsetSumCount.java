package dsa.problems.DpPart2.knapsack.knapsackZeroOne;

public class SubsetSumCount {

    public static int subSet(int arr[], int target) {

        int n = arr.length;
        int dp[][] = new int[n + 1][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String a[]) {
        int arr[] = {2, 3, 5, 2, 7};
        System.out.println("Subset Sum Problem");
        System.out.println(subSet(arr, 7));
    }


}
