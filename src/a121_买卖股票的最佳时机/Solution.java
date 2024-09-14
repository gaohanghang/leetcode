package a121_买卖股票的最佳时机;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-09-14 14:18
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
