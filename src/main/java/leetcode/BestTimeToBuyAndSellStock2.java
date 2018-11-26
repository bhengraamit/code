package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0)
            return 0;
        int local_min = -1, local_sum = 0, total_sum = 0;
        int prev = prices[0];
        for(int i=0; i<prices.length; i++){
            if(local_min>=0){
                if(prices[i] - prev >= 0)
                    local_sum = prices[i] - local_min;
                else{
                    local_min = -1; total_sum += local_sum;
                }
            }else{
                if(prices[i] - prev > 0){
                    local_min = prices[i-1];
                    local_sum = prices[i] - local_min;
                }
            }
            prev = prices[i];
        }

        if(local_min >= 0)
            total_sum += local_sum;
        return total_sum;
    }
}
