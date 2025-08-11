package dsa.problems.stringimp.kmp;

import java.util.Arrays;

public class ShortestPalindrome {
        public static  int [] lps (String p){
            int i =1;
            int j =0;

            int dp[] = new int[p.length()];
            while(i<p.length()){
                if(p.charAt(i)==p.charAt(j)){
                    dp[i] = j+1;
                    i++;
                    j++;
                }else{
                    if(j!=0){
                        j = dp[j-1];
                    }else{
                        i++;
                    }
                }
            }
            return dp;
        }
        public static String shortestPalindrome(String s) {

            String rev = new StringBuilder(s).reverse().toString();

            String c = s +"#"+rev;
            int dp[] = lps(c);
            int palindromeLength = dp[c.length()-1];
            String suffix = s.substring(palindromeLength);
            return new StringBuilder(suffix).reverse().append(s).toString();

        }

        public static void main(String[] args) {
            ShortestPalindrome sp = new ShortestPalindrome();
            System.out.println(Arrays.toString(sp.lps("aacecaaa")));
            System.out.println(sp.shortestPalindrome("aacecaaa")); // aaacecaaa
            System.out.println(Arrays.toString(sp.lps("abcd")));
            System.out.println(sp.shortestPalindrome("abcd"));     // dcbabcd

    }

}
