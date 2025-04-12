package dsa.problems.string;

public class LongestPalindromicSubstring {
    class Solution {
        public static String check(String s, int left, int right){
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            return s.substring(left+1,right);
        }
        public String longestPalindrome(String s) {
            int maxLength =0;
            String longest = "";

            for(int i =0;i<s.length();i++){

                String odd = check(s,i,i);
                String even = check(s,i,i+1);

                if(odd.length()>maxLength){
                    maxLength = odd.length();
                    longest = odd;
                }
                if(even.length()>maxLength){
                    maxLength = even.length();
                    longest = even;
                }
            }

            return longest;
        }
    }
}
