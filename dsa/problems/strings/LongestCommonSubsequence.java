package dsa.problems.strings;



//Leetcode//1312. Minimum Insertion Steps to Make a String Palindrome
public class LongestCommonSubsequence {
public int minInsertions(String s) {

    String sb = new StringBuilder(s).reverse().toString();
    int  n= s.length();
    int dp [] [] = new int[n+1][n+1];
    for(int i =1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(s.charAt(i-1)==sb.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1]+1;
            }else{
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
    }
    int lps = dp[n][n];
    return n-lps;

}
}

//Problem 2:/// Min Chars to Add for Palindrome geeks for geeks
class Solution {
    public static int [] computeLps(String s){
        int n = s.length();
        int lps[] = new int[n];
        int i =1;
        int len =0;

        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    len =0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static int minChar(String s) {
        String sb = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + sb;

        int[] lps = computeLps(combined);

        return s.length() - lps[combined.length() - 1];


        // Write your code here
    }
}