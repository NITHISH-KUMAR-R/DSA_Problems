package dsa.problems.backTracking;

public class Pow {
    class Solution {
        public double fastPow(double b, int e){
            if(e==0){
                return 1.0;
            }
            double half = fastPow(b, e/2);
            return e%2==0 ? half * half : half * half * b;
        }
        public double myPow(double x, int n) {

            if(n==0) return 1.0;

            if(n< 0){
                x= 1/x;
                n=-n;
            }
            return fastPow(x,n);
        }
    }
}
