package dsa.problems.dp;

public class DecodeProblem {
    class Solution {
        public int countWays(String digits) {
            int n = digits.length();
            // code here

            int dp [] = new int[n+1];

            dp[0] =1;
            dp[1]= digits.charAt(0)=='0' ?0:1;

            for(int i =2;i<=n;i++){
                int oneDigit = Integer.valueOf(digits.substring(i-1,i));
                int twoDigit = Integer.valueOf(digits.substring(i-2,i));

                if (oneDigit >= 1 && oneDigit <= 9) {
                    dp[i] += dp[i - 1];
                }

                if(twoDigit >=10 && twoDigit <=26){
                    dp[i] += dp[i-2];
                }


            }

            return dp[n];

        }
    }
}

///Decode Strings
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26 count ways