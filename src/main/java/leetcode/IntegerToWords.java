package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 24/08/18.
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 */
public class IntegerToWords {
    static Map<Integer,String> hardDigitMap = new HashMap<>();
    static Map<Integer,String> doubleDigitMap = new HashMap<>();
    static Map<Integer,String> commaIndexMap = new HashMap<>();
    static int[] unitsArray = new int[]{1000000000,1000000,1000};

    static{
        commaIndexMap.put(1000000000,"Billion");
        commaIndexMap.put(1000000,"Million");
        commaIndexMap.put(1000,"Thousand");

        hardDigitMap.put(1,"One");
        hardDigitMap.put(2,"Two");
        hardDigitMap.put(3,"Three");
        hardDigitMap.put(4,"Four");
        hardDigitMap.put(5,"Five");
        hardDigitMap.put(6,"Six");
        hardDigitMap.put(7,"Seven");
        hardDigitMap.put(8,"Eight");
        hardDigitMap.put(9,"Nine");
        hardDigitMap.put(10,"Ten");
        hardDigitMap.put(11,"Eleven");
        hardDigitMap.put(12,"Twelve");
        hardDigitMap.put(13,"Thirteen");
        hardDigitMap.put(14,"Fourteen");
        hardDigitMap.put(15,"Fifteen");
        hardDigitMap.put(16,"Sixteen");
        hardDigitMap.put(17,"Seventeen");
        hardDigitMap.put(18,"Eighteen");
        hardDigitMap.put(19,"Nineteen");
        hardDigitMap.put(20,"Twenty");

        doubleDigitMap.put(2,"Twenty");
        doubleDigitMap.put(3,"Thirty");
        doubleDigitMap.put(4,"Forty");
        doubleDigitMap.put(5,"Fifty");
        doubleDigitMap.put(6,"Sixty");
        doubleDigitMap.put(7,"Seventy");
        doubleDigitMap.put(8,"Eighty");
        doubleDigitMap.put(9,"Ninety");
    }


    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String finalWord = "";
        for(int unit : unitsArray){
            int div = num / unit;
            int rem = num % unit;
            if(div !=0){
                String word = getWords(div) + " " + commaIndexMap.get(unit);
                if(!word.isEmpty())
                    finalWord +=  " " + word;
            }
            num = rem;
        }
        if(num!=0){
            String word = getWords(num);
            if(!word.isEmpty())
                finalWord += " " + word;
        }
        return finalWord.trim();
    }
    /**
     will always recieve 1,2 or 3 digits only
     */
    public String getWords(int num){
        if(num == 0)
            return "";
        if( num / 10 > 0){    // can be 2 or 3 digit

            if(num / 100 > 0){  // its 3 digit
                int div = num / 100;
                int rem = num % 100;
                String word = getWords(rem);
                String finalWord = hardDigitMap.get(div) + " " + "Hundred" ;
                if(!word.isEmpty())
                    finalWord += " " + word;
                return finalWord;

            }else{        // its 2 digit
                if(hardDigitMap.get(num)!=null)
                    return hardDigitMap.get(num);
                else{
                    int div = num / 10;
                    int rem = num % 10;
                    String word = getWords(rem);
                    String finalWord = doubleDigitMap.get(div);
                    if(!word.isEmpty())
                        finalWord += " " + word;
                    return finalWord;
                }
            }

        }else{      // its single digit
            return hardDigitMap.get(num);
        }
    }
}
