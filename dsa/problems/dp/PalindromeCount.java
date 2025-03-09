package dsa.problems.dp;

public class PalindromeCount {
    class Solution {
        public static int check(String s, int left, int right){
            int count=0;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1>=2){
                    count++;
                }
                left--;
                right++;
            }

            return count;
        }
        public int countPS(String s) {
            // code here

            int count =0;
            for(int i =0;i<s.length();i++){
                count+= check(s,i,i);
                count+= check(s,i,i+1);

            }

            return count;
        }
    }
}

//Expand around center
//Palindrome SubStrings gfg