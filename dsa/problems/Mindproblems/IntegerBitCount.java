package dsa.problems.Mindproblems;

public class IntegerBitCount {
    //3304. Find the K-th Character in String Game I
    class Solution {
        public char kthCharacter(int k) {
            return (char)('a' + Integer.bitCount(k - 1));
        }
    }
}
