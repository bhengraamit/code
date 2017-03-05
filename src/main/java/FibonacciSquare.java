import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by amit.bhengra on 08/11/16.
 *
 *
 *
 * https://www.hackerrank.com/challenges/fibonacci-modified
 *
 *
 */
public class FibonacciSquare {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer firstNum = reader.nextInt();
        Integer secondNum = reader.nextInt();
        Integer nthNum = reader.nextInt();

        reader.nextLine();

        if (nthNum==1) {
            System.out.println(firstNum);
            return;
        }

        if (nthNum==2){
            System.out.println(secondNum);
            return;
        }

        nthNum = nthNum-2;
        BigInteger nthValue = new BigInteger("0");
        BigInteger firstBigNum = new BigInteger(String.valueOf(firstNum));
        BigInteger secondBigNum = new BigInteger(String.valueOf(secondNum));
        while (nthNum-- > 0){
            BigInteger tempNum = secondBigNum.multiply(secondBigNum);
            nthValue = firstBigNum.add(tempNum);
            firstBigNum = secondBigNum;
            secondBigNum = nthValue;
        }
        System.out.println(nthValue);
    }
}
