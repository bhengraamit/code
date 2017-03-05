import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit.bhengra on 19/12/16.
 */
public class ValidPassword {

    public static void main(String[] args) {
        System.out.println(solution("a0Ba"));
        System.out.println(solution("a0bb"));
        System.out.println(solution("123"));
        System.out.println(solution("Dab12445abcdfFc"));
        System.out.println(solution("1"));
        System.out.println(solution("DDD13466aBkg1DEFZA"));
        System.out.println(solution("AazZ"));
    }

    public static int solution(String input) {
        // write your code in Java SE 8

        if (input!=null){
            if (input.isEmpty())
                return -1;
            char[] chars = input.toCharArray();
            Integer start = null;
            Integer end = null;
            int index = 0;
            int maxLength = 0;
            for (Character ch:chars){

                if (isAlphabet(ch) && start==null) {
                    start = index;
                    if (index == chars.length-1) {                      // what if this is the first and last char
                        end = index;
                        int length = checkValidLength(start, end, chars);
                        if (length > maxLength)
                            maxLength = length;
                    }
                }
                else if (isNumber(ch) || index == chars.length-1){           // calculate validity if a number has come or its the end of array
                    if (start != null){
                        if (isNumber(ch))
                            end = index-1;   //assigning end to previous index
                        else
                            end = index;   // this case is for last index
                        int length = checkValidLength(start,end,chars);
                        if (length >maxLength)
                            maxLength = length;
                        start = null;                   //starting again
                        end = null;
                    }
                }

                index++;
            }

            if (maxLength==0)
                return -1;
            else
                return maxLength;

        }
        return -1;
    }

    /*
    Returns 0 if invalid otherwise the length of string
     */
    private static int checkValidLength(Integer start, Integer end, char[] chars) {
        boolean isUpperCase = false;
        for (int i = start; i<=end; i++){
            if (isAlphabetUppercase(chars[i])) {
                isUpperCase = true;
            }
        }
        if (isUpperCase)
            return end-start+1;
        else
            return 0;
    }

    //Checking ascii code ranges for numbers and alphabets

    public static boolean isNumber(Character ch){
        if (ch >=48 && ch<=57)
            return true;
        else
            return false;
    }

    public static boolean isAlphabet(Character ch){
        if ((ch >=65 && ch<=90) || (ch>=97 && ch <=122))
            return true;
        else
            return false;
    }

    public static boolean isAlphabetUppercase(Character ch){
        if (ch>=65 && ch <=90)
            return true;
        else
            return false;
    }
}
