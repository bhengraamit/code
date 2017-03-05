import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 21/12/16.
 */
public class Base7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Long num = Long.valueOf(bi.readLine());
        Character[] base7 = new Character[7];
        base7[0]='0';
        base7[1]='a';
        base7[2]='t';
        base7[3]='l';
        base7[4]='s';
        base7[5]='i';
        base7[6]='n';
        long div = num/7l;
        Long rem = num%7l;
        List<Integer> remList = new ArrayList<>();
        remList.add(rem.intValue());
        while (div!=0){
            rem = div%7l;
            div = div/7l;
            remList.add(rem.intValue());
        }
        int index = remList.size()-1;
        String finalString = "";
        while (index>=0){
            finalString += String.valueOf(base7[remList.get(index)]);
            index--;
        }

        System.out.println(finalString);
    }
}
