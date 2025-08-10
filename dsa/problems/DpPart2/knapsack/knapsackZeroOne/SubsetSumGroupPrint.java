package dsa.problems.DpPart2.knapsack.knapsackZeroOne;


import java.util.ArrayList;
import java.util.List;

class SubsetSumGroupPrint {

    static void printAllSubsets(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        // Base case: sum 0 is always possible (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }
        // If target sum is not possible
        if (!dp[n][sum]) {
            System.out.println("No subsets found");
            return;
        }
        // Backtrack to print all subsets
        backtrack(arr, n, sum, new ArrayList<>(), dp);
    }

    static void backtrack(int[] arr, int i, int sum, List<Integer> path, boolean[][] dp) {
        if (sum == 0) {
            System.out.println(path);
            return;
        }
        if (i == 0) return;
        // Exclude current element
        if (dp[i-1][sum]) {
            backtrack(arr, i-1, sum, new ArrayList<>(path), dp);
        }
        // Include current element
        if (sum >= arr[i-1] && dp[i-1][sum - arr[i-1]]) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(arr[i-1]);
            backtrack(arr, i-1, sum - arr[i-1], newPath, dp);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 7,5};
        int sum = 7;
        printAllSubsets(arr, sum);
    }
}
