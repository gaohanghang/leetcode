package a121_买卖股票的最佳时机;

/**
 * @author Gao Hanghang
 * @version 1.0
 * @description
 * @date 2024-09-14 14:25
 **/
public class Solution2 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] - prices[i] > maxprofit) {
                    maxprofit = prices[j] - prices[i];
                }
            }
        }
        return maxprofit;
    }
}
