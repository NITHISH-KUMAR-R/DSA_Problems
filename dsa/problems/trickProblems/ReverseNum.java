package dsa.problems.trickProblems;

public class ReverseNum {
    class Solution {
        public int reverse(int x) {

            int max =Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            int res = 0;
            while(x!=0){
                int lastDigit = x % 10;
                x = x/10;
                if(res > max/10 || res == max/10 && lastDigit > 7){
                    return 0;
                }
                if(res  < min/10 || res == min/10 && lastDigit < -8){
                    return 0;
                }

                res = res*10 + lastDigit;

            }
            return res;


        }
    }

}
