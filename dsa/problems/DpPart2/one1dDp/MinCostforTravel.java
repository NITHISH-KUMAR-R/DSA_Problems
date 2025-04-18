package dsa.problems.DpPart2.one1dDp;

import java.util.HashSet;
import java.util.Set;

public class MinCostforTravel {
    //983. Minimum Cost For Tickets
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {

            Set<Integer> travelDays = new HashSet<>();
            for(int i : days){
                travelDays.add(i);
            }

            int lastDay = days[days.length-1];
            int dp[] = new int[lastDay+1];
            for(int i=1;i<=lastDay;i++){
                if(!travelDays.contains(i)){
                    dp[i]= dp[i-1];
                }else{
                    int Day1 = dp[Math.max(0,i-1)]+costs[0];
                    int days7 = dp[Math.max(0,i-7)]+costs[1];
                    int days30 = dp[Math.max(0,i-30)]+costs[2];

                    dp[i] = Math.min(Day1, Math.min(days30,days7));
                }

            }
            return dp[lastDay];

        }
    }
}
