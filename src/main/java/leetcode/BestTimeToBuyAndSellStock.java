package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while(i < prices.length){
            if(prices[i] < min)
                min = prices[i];
            if(prices[i]-min > maxProfit)
                maxProfit = prices[i] - min;
            i++;
        }
        return maxProfit;
    }
}
