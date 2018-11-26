import java.util.HashMap;
import java.math.BigInteger;
import java.util.Map;

/**
 * Created by amit.bhengra on 25/03/17.
 */
public class ConvertBase {
    public static void main(String[] args) {
        //BigInteger test = new BigInteger(String.valueOf(7.0));
       // System.out.println(convertBase("abcABCD","0123456789","Da"));
        System.out.println(convertBase("0123456789", "01", "7"));
    }

    public static String convertBase(String input1,String input2, String input3){
        BigInteger decimalValue = convertToDecimalBig(input1,input3);
        String returnValue = convertToOtherLibraryBig(decimalValue,input2);
        return returnValue;
    }

    private static String convertToOtherLibraryBig(BigInteger decimalValue, String input2) {
        int divisor = input2.length();

        char[] chArr = input2.toCharArray();
        Map<BigInteger,Character> map = new HashMap<>();
        int i =0;
        for (char ch: chArr){
            map.put(new BigInteger(String.valueOf(i)),ch);
            i++;
        }
        BigInteger quot = decimalValue.divide(new BigInteger(String.valueOf(divisor)));
        BigInteger rem = decimalValue.remainder(new BigInteger(String.valueOf(divisor))) ;
        String retValue = String.valueOf(map.get(rem));

        while (quot.compareTo(new BigInteger(String.valueOf(divisor))) >=0){
            rem = quot.remainder(new BigInteger(String.valueOf(divisor))) ;//quot % divisor;
            quot = quot.divide(new BigInteger(String.valueOf(divisor)));//quot / divisor;
            retValue = String.valueOf(map.get(rem)) + retValue;
        }
        if (quot.intValue() >0)
            retValue = String.valueOf(map.get(quot)) + retValue;
        return retValue;
    }

    private static BigInteger convertToDecimalBig(String input1, String input3) {
        char[] chArr = input1.toCharArray();
        int size = input1.length();
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        for (char ch : chArr){
            map.put(ch,i);
            i++;
        }
        char[] valueArr = input3.toCharArray();
        int valueSize = 0;
        BigInteger valueSum = new BigInteger(String.valueOf(0));
        int pow = input3.length() - 1;
        while (valueSize < input3.length() ){
            valueSum = valueSum.add(new BigInteger(String.valueOf((int)Math.pow(size,pow))).multiply(new BigInteger(String.valueOf(map.get(valueArr[valueSize])))));
//            valueSum += Math.pow(size,pow) * map.get(valueArr[valueSize]);
            valueSize++;
            pow--;
        }
        return valueSum;
    }

    private static String convertToOtherLibrary(int decimalValue, String input2) {
        int divisor = input2.length();

        char[] chArr = input2.toCharArray();
        Map<Integer,Character> map = new HashMap<>();
        int i =0;
        for (char ch: chArr){
            map.put(i,ch);
            i++;
        }
        int quot = decimalValue / divisor;
        int rem = decimalValue % divisor;
        String retValue = String.valueOf(map.get(rem));

        while (quot >= divisor){
            rem = quot % divisor;
            quot = quot / divisor;
            retValue = String.valueOf(map.get(rem)) + retValue;
        }
        if (quot >0)
            retValue = String.valueOf(map.get(quot)) + retValue;
        return retValue;
    }

    private static int convertToDecimal(String input1, String input3) {
        char[] chArr = input1.toCharArray();
        int size = input1.length();
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        for (char ch : chArr){
            map.put(ch,i);
            i++;
        }
        char[] valueArr = input3.toCharArray();
        int valueSize = 0;
        int valueSum = 0;
        int pow = input3.length() - 1;
        while (valueSize < input3.length() ){
            valueSum += map.get(valueArr[valueSize]) * Math.pow(size,pow);
            valueSize++;
            pow--;
        }
        return valueSum;
    }


}
