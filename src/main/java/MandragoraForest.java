import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by amit.bhengra on 18/11/16.
 * https://www.hackerrank.com/challenges/mandragora
 */
public class MandragoraForest {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bi.readLine());

        while (testCases-- > 0){
            int mandNum = Integer.parseInt(bi.readLine());
            String arr = bi.readLine();
            String[] strArr = arr.split(" ");
            List<String> list = Arrays.asList(strArr);
            int[] numArr = list.stream().mapToInt(Integer::parseInt).sorted().toArray();

            BigInteger largestSum = new BigInteger("0");
            BigInteger prevSum = new BigInteger("0");

            while (mandNum-- > 0){
                prevSum = prevSum.add(new BigInteger(String.valueOf(numArr[mandNum])));
                Integer totalEaten = 1 + mandNum;
                BigInteger currentSum = prevSum.multiply(new BigInteger(totalEaten.toString()));
                if (largestSum.compareTo(currentSum) < 0 )
                    largestSum = currentSum;
            }
            System.out.println(largestSum);
        }
    }
}
