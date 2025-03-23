package dsa.problems.dp;

public class StockbuySellEasy {
    class Solution {
        public int maxProfit(int[] prices) {
            int buyPrice = prices[0];

            int maxProfit =0;
            int currProfit =0;

            for(int i =1;i<prices.length;i++){
                if(prices[i]<buyPrice){
                    buyPrice = prices[i];
                }

                else{
                    currProfit =  prices[i] - buyPrice;
                    maxProfit = Math.max(currProfit,maxProfit);
                }
            }
            return maxProfit;
        }
    }
}
