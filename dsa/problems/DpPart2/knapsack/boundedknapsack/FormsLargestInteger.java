package dsa.problems.DpPart2.knapsack.boundedknapsack;

import java.util.Arrays;

public class FormsLargestInteger {
//1449. Form Largest Integer With Digits That Add up to Target
        public String better(String a , String b){

            if(a.equals("0")) return b;
            if(b.equals("0")) return a;
            if(a.length()!=b.length()) return a.length() > b.length() ? a: b;
            return a.compareTo(b)>0 ? a: b;
        }
        public String largestNumber(int[] cost, int target) {

            String dp[] = new String[target+1];
            Arrays.fill(dp,"0");
            dp[0] = "";

            for(int d = 9;d>=1;d--){
                int c = cost[d-1];
                for(int t =c;t<=target;t++){
                    if(!dp[t-c].equals("0")){
                        dp[t] = better(dp[t],dp[t-c]+d);
                    }
                }
            }

            return dp[target];
        }

}
