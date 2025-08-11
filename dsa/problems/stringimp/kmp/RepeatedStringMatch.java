package dsa.problems.stringimp.kmp;

public class RepeatedStringMatch {
        public int[] lps(String p) {
            int i = 1;
            int j = 0;
            int dp[] = new int[p.length()];

            while (i < p.length()) {
                if (p.charAt(i) == p.charAt(j)) {
                    dp[i] = j + 1;
                    i++;
                    j++;

                } else {
                    if (j != 0) {
                        j = dp[j - 1];
                    } else {
                        i++;
                    }
                }
            }
            return dp;
        }

        public boolean kmp(String s, String p) {
            int i = 0;
            int j = 0;
            int dp[] = lps(p);
            while (i < s.length()) {
                if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    if (j == p.length())
                        return true;
                } else {
                    if (j != 0) {
                        j = dp[j - 1];
                    } else {
                        i++;
                    }
                }
            }

            return false;
        }

        public int repeatedStringMatch(String a, String b) {
            int count = 1;
            String c = a;
            while (a.length() < b.length()) {
                a += c;
                count++;
            }

            if (kmp(a, b))
                return count;

            a += c;
            count++;
            if (kmp(a, b))
                return count;

            return -1;

        }

}
