import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by amit.bhengra on 18/11/16.
 * https://www.hackerrank.com/challenges/candies
 */
public class Candies {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bi.readLine());

        ArrayList<Integer> array = new ArrayList<>(testCases);
        while (testCases-- > 0){
            Integer num = Integer.parseInt(bi.readLine());
            array.add(num);
        }
        // left to right
        int prevNum = array.get(0);
        int count = 1;
        BigInteger candiesSum = new BigInteger("1");
        BigInteger prevCandiesSum = new BigInteger("1");
        BigInteger[] candiesArray = new BigInteger[array.size()];
        candiesArray[0] = prevCandiesSum;
        while (count < array.size()){
            int currNum = array.get(count);
            if (currNum > prevNum) {
                candiesSum = candiesSum.add(prevCandiesSum.add(new BigInteger("1")));
                prevCandiesSum = prevCandiesSum.add(new BigInteger("1"));
            }else {
                candiesSum = candiesSum.add(new BigInteger("1"));
                prevCandiesSum = new BigInteger("1");
            }
            prevNum = currNum;
            candiesArray[count] = prevCandiesSum;
            count++;
        }

        // right to left

        count = count-2;  // move to second last position

        while(count >=0){
            if (array.get(count) > array.get(count+1)){
                if (candiesArray[count].compareTo(candiesArray[count+1].add(new BigInteger("1"))) < 0){
                    BigInteger oldNum = candiesArray[count];
                    candiesArray[count] = candiesArray[count+1].add(new BigInteger("1"));
                    candiesSum = candiesSum.add(candiesArray[count].subtract(oldNum));
                }
            }
            count--;
        }
        System.out.println(candiesSum);
    }
}
