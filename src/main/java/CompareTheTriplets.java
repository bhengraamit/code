import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by amit.bhengra on 27/11/16.
 */
public class CompareTheTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String firstStr = bi.readLine();
        String secondStr = bi.readLine();

        int[] firstArr = Arrays.asList(firstStr.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.asList(secondStr.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0 ; i < firstArr.length; i++){
            if (firstArr[i] > secondArr[i])
                aliceScore += 1;
            else if (firstArr[i] < secondArr[i])
                bobScore +=1 ;
        }

        System.out.println(aliceScore+" "+bobScore);

    }
}
