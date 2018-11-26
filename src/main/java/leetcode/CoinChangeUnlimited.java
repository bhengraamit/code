package leetcode;

/**
 * Created by amit.bhengra on 17/10/18.
 *
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChangeUnlimited {

    public static void main(String[] args) {
        CoinChangeUnlimited coinChangeUnlimited = new CoinChangeUnlimited();
        int[]nums ={186,419,83,408};
        coinChangeUnlimited.coinChange(nums,6249);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins == null || coins.length == 0 || amount <0)
            return -1;

        int[] minCount = new int[amount+1];
        int minCoin = Integer.MAX_VALUE;
        for(int i=0; i<coins.length ;i++){
            if(coins[i] < minCoin)
                minCoin = coins[i];
            if(coins[i] < amount+1)
                minCount[coins[i]] = 1;
        }

        for(int i=minCoin ; i< amount+1 ; i++){
            if(minCount[i] == 0)
                continue;
            for(int j=0; j<coins.length; j++){
                System.out.println("Number:"+i+" Coin:"+coins[j]);
                long index = (long)i+coins[j];
                if(index < amount+1){
                    if(minCount[i+coins[j]]==0 || minCount[i]+1 < minCount[i+coins[j]]){
                        minCount[i+coins[j]] = minCount[i] +1;
                        System.out.println("Number:" +(i+coins[j])+" Min:"+minCount[i+coins[j]] );
                    }
                }
            }
        }

        if(minCount[amount]==0)
            return -1;
        return minCount[amount];
    }
}
