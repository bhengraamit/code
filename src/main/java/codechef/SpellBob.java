package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by amit.bhengra on 04/08/18.
 * https://www.codechef.com/AUG18B/problems/SPELLBOB
 */

public class SpellBob {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.valueOf(bi.readLine());

        while (testCases-- > 0){
            String firstLine = bi.readLine();
            String secondLine = bi.readLine();
            String status = checkForBob(firstLine,secondLine);
            System.out.println(status);
        }
    }

    private static String checkForBob(String firstLine, String secondLine) {
        char[] topChar = firstLine.toCharArray();
        char[] bottomChar = secondLine.toCharArray();
        BobCount topBobCount = countBob(topChar);
        BobCount bottomBobCount = countBob(bottomChar);
        if (isBob(topBobCount))
            return "yes";
        if (isBob(bottomBobCount))
            return "yes";

        for (int i = 0; i < 3; i++){
            BobCount topBobCountCopy = new BobCount(topBobCount);
            BobCount bottomBobCountCopy = new BobCount(bottomBobCount);
            for (int j = i; j<3; j++){
                if (flipCardsAndCheck(topChar[j], bottomChar[j], topBobCountCopy)) return "yes";
                if (flipCardsAndCheck(bottomChar[j], topChar[j], bottomBobCountCopy)) return "yes";
            }
        }

        return "no";
    }

    private static boolean flipCardsAndCheck(char c, char c1, BobCount topBobCountCopy) {
        updateBobCount(topBobCountCopy, c,-1);
        updateBobCount(topBobCountCopy, c1,1);
        if (isBob(topBobCountCopy))
            return true;
        return false;
    }

    private static boolean isBob(BobCount topBobCount) {
        return topBobCount.b == 2 && topBobCount.o ==1;
    }

    private static void updateBobCount(BobCount bobCount,char c,int count){
        switch (c){
            case 'b' : bobCount.b += count;break;
            case 'o' : bobCount.o += count;break;
            default:break;
        }

    }

    private static BobCount countBob(char[] topChar) {
        BobCount bobCount = new BobCount();
        for (char c : topChar){
            switch (c){
                case 'b' : bobCount.b++;break;
                case 'o' : bobCount.o++;break;
                default:break;
            }
        }
        return bobCount;
    }

    private static class BobCount{
        int b =0;
        int o = 0;

        public BobCount() {
        }

        public BobCount(BobCount bobCount) {
            this.b = bobCount.b;
            this.o = bobCount.o;
        }
    }
}
