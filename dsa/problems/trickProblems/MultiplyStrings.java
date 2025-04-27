package dsa.problems.trickProblems;

import java.math.BigInteger;

public class MultiplyStrings {
    class Solution {
        public String multiplyStrings(String s1, String s2) {
            // code here.
            return (new BigInteger(s1).multiply(new BigInteger(s2))).toString();
        }
    }
}
