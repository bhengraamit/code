import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit.bhengra on 21/12/16.
 */
public class LookAndSay {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String num = bi.readLine();
        int repeat = Integer.valueOf(bi.readLine());
        String newNum = num;
        while (repeat-- >0){
             newNum = lookAndSay(newNum);
        }
        System.out.println(newNum);

    }

    private static String lookAndSay(String num) {
        char[] ch = num.toCharArray();
        String finalString = "";
        int count = 1;
        char prevCh = ch[0];
        for (int i=1; i<ch.length; i++){
            if (ch[i] ==prevCh){
                count++;
            }
            else{
                finalString += count+String.valueOf(prevCh);
                prevCh = ch[i];
                count = 1;
            }
        }
        finalString += count+String.valueOf(prevCh);
        return finalString;
    }
}
