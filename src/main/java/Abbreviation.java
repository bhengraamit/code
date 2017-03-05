import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit.bhengra on 27/11/16.
 * https://www.hackerrank.com/challenges/abbr
 */
public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bi.readLine());

        while (testCases-- > 0){
            String aString = bi.readLine();
            String bString = bi.readLine();
            char[] aArr = aString.toCharArray();
            char[] bArr = bString.toCharArray();
            int bArrIndex = 0;
            int aArrIndex = 0;
            boolean capitalCame = false;
            boolean notMatch = false;
            while (aArrIndex < aArr.length){
//                if (bArrIndex == bArr.length)
//                    break;
                char ch = aArr[aArrIndex];
                if (bArrIndex < bArr.length && bArr[bArrIndex] == Character.toUpperCase(ch)) {
                    bArrIndex++;
                }
                else if (Character.isUpperCase(ch)) {
                    notMatch = true;
                    break;  // any capital not matching with b Arr char then match not possible
                }

                aArrIndex++;
            }

            if (bArrIndex == bArr.length && !notMatch){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}

