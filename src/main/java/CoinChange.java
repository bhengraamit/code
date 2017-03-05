import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by amit.bhengra on 21/11/16.
 * https://www.hackerrank.com/challenges/coin-change
 */
public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String testCase = bi.readLine();
        String arr[]= testCase.split(" ");
        int amount = Integer.valueOf(arr[0]);
        int numOfCoins = Integer.valueOf(arr[1]);
        String coinnsStr = bi.readLine();
        String coinArr[] = coinnsStr.split(" ");
        int coins[] = Arrays.asList(coinArr).stream().mapToInt(Integer::parseInt).toArray();
        BigInteger[][] memoized = new BigInteger[amount+1][numOfCoins+1];
        for (int j=0; j<=numOfCoins;j++){
            memoized[0][j] = new BigInteger("1");
        }
        BigInteger totalWays = coinChange(amount,0,coins,memoized);
        System.out.println(totalWays);
    }

    private static BigInteger coinChange(int amount, int i, int[] coins, BigInteger[][] memoized) {
        if (i == coins.length)
            return new BigInteger("0");

        if (amount == 0){
            return memoized[amount][i];
        }
        BigInteger sum = null;
        if (coins[i] <= amount){
            BigInteger firstSum = null;
            BigInteger secondSum = null;
            if (memoized[amount-coins[i]][i]!=null){
                firstSum = memoized[amount-coins[i]][i];
            }else {
                firstSum = coinChange(amount - coins[i], i, coins, memoized);
            }

            if (memoized[amount][i+1]!=null){
                secondSum = memoized[amount][i+1];
            }else {
                secondSum = coinChange(amount,i+1,coins,memoized);
            }
            sum = firstSum.add(secondSum);
        }else if (coins[i] > amount){
            if (memoized[amount][i+1]!=null){
                sum = memoized[amount][i+1];
            }else {
                sum = coinChange(amount, i + 1, coins, memoized);
            }
        }
        if (sum!=null){
            memoized[amount][i] = sum;
            return sum;
        }
        return null;
    }
}
