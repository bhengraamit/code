package leetcode;

import java.util.Stack;

/**
 * Created by amit.bhengra on 25/09/18.
 */
public class StocksWithFees {

    public int maxProfit(int[] prices, int fee) {
        int max = 0;
        if(prices == null || prices.length <=1)
            return max;
        // min 2 length
        Stack<Integer> stocks = new Stack<Integer>();
        stocks.push(prices[0]);
        for(int i=1; i<prices.length; i++){
            while(!stocks.empty() && stocks.peek() >= prices[i]){
                stocks.pop();
            }
            if(!stocks.empty()){
                int value = stocks.peek();
                int profit = prices[i] - value - fee;
                max = max < profit ? profit : max;
            }else{
                stocks.push(prices[i]);
            }
        }

        return max;
    }
}
