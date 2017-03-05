import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amit.bhengra on 25/11/16.
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 */
public class SherlockandCost {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bi.readLine());

        while (testCases-- >0){
            int num = Integer.parseInt(bi.readLine());
            String str = bi.readLine();
            String[] strArr = str.split(" ");
            List<String> list = Arrays.asList(strArr);
            int[] numArr = list.stream().mapToInt(Integer::parseInt).toArray();

            int oddSum = 0;
            int evenSum = 0;
            for (int i =0; i<numArr.length; i++){
                int odd = i%2;
                if (odd==0){
                    if (i==0 || i == numArr.length-1){
                        oddSum += numArr[i]-1;
                    }else {
                        oddSum += (numArr[i]-1)*2;
                    }
                }else if (odd==1){
                    if (i== numArr.length-1){
                        evenSum += numArr[i]-1;
                    }else{
                        evenSum += (numArr[i]-1)*2;
                    }
                }
            }

            System.out.println(oddSum > evenSum ? oddSum:evenSum);
        }
    }
}
