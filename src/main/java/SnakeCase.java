import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit.bhengra on 18/12/16.
 * https://www.hackerrank.com/contests/world-codesprint-8/challenges/snake-case
 */

public class SnakeCase {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String str = bi.readLine();
        System.out.println(str.split("_").length);
    }
}
