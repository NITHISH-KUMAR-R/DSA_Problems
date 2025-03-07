package dsa.problems.dp;

public class LongestPalindromeString {
    class Solution {
        public static String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";

            int maxLen = 0;
            String longestPalindrome = "";

            for (int i = 0; i < s.length(); i++) {
                // Expand for odd-length palindrome
                String oddPalindrome = expandAroundCenter(s, i, i);
                if (oddPalindrome.length() > maxLen) {
                    maxLen = oddPalindrome.length();
                    longestPalindrome = oddPalindrome;
                }

                // Expand for even-length palindrome
                String evenPalindrome = expandAroundCenter(s, i, i + 1);
                if (evenPalindrome.length() > maxLen) {
                    maxLen = evenPalindrome.length();
                    longestPalindrome = evenPalindrome;
                }
            }
            return longestPalindrome;
        }

        private static String expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }
    }

}
