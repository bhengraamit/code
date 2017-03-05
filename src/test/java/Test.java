import java.math.BigInteger;

/**
 * Created by amit.bhengra on 18/11/16.
 */
public class Test {

    public static void main(String[] args) {
        int centerX = 50;
        int centerY = 50;
        System.out.println(calculateDegree(centerX, centerY, 48,100));
        System.out.println(findLength(centerX, centerY, 75,75));
    }

    private static double calculateDegree(int centerX, int centerY, int x, int y) {
        return Math.toDegrees(Math.atan2(Math.abs(centerY - y), Math.abs(centerX - x)));
    }

    private static double findLength(int centerX, int centerY, int x, int y) {
        return Math.sqrt(Math.pow(Math.abs(centerX-x),2) + Math.pow(Math.abs(centerY-y),2));
    }


}
