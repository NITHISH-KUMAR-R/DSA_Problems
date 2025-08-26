package dsa.problems.DpPart2;

public class CountAllPalindrome {
        static final int MOD = 1_000_000_007;
        int[][] dp;

        public int helper(String s, int i, int j) {
            if (i > j) return 0;
            if (i == j) return 1; // single char is palindrome

            if (dp[i][j] != -1) return dp[i][j];

            if (s.charAt(i) == s.charAt(j)) {
                // include subsequences inside + subsequences with i or j + 1 new palindrome (s[i..j])
                dp[i][j] = (1 + helper(s, i + 1, j) + helper(s, i, j - 1)) % MOD;
            } else {
                // inclusion-exclusion
                dp[i][j] = (MOD + helper(s, i + 1, j) + helper(s, i, j - 1) - helper(s, i + 1, j - 1)) % MOD;
            }

            return dp[i][j];
        }

        int countPS(String s) {
            int n = s.length();
            dp = new int[n][n];

            // initialize dp with -1
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }

            return helper(s, 0, n - 1);
        }
    }

