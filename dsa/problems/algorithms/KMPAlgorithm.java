package dsa.problems.algorithms;


import java.util.ArrayList;
class KMPAlgorithm {
    public int [] computeTemporaryArray(String pattern){
        int lps[] = new int[pattern.length()];
        int i =1;
        int len =0;
        int m = pattern.length();
        while(i<m){
            if(pattern.charAt(len)==pattern.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();
        int [] lps = computeTemporaryArray(pat);
        int i = 0; // Index for txt
        int j = 0; // Index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                // Pattern found, add starting index to result
                result.add(i - j);
                j = lps[j - 1]; // Reset j using LPS
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Reset j using LPS
                } else {
                    i++;
                }
            }
        }

        return result;

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
