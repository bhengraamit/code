package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        List<Integer> intValues = getIntValues();
        Map<Integer,String> intIndexToStr = getIntIndextoString();
        StringBuilder finalStr = new StringBuilder();
        while(num > 0){
            for(int i=0; i<intValues.size(); i++){
                int quo = num / intValues.get(i);
                if( quo>=1){
                    for(int j=quo; j>0; j--)
                        finalStr.append(intIndexToStr.get(i));
                    num -= quo*intValues.get(i);
                    break;
                }
            }
        }
        return finalStr.toString();
    }

    public List<Integer> getIntValues(){
        List<Integer> values = new ArrayList<>();
        values.add(1000);
        values.add(900);
        values.add(500);
        values.add(400);
        values.add(100);
        values.add(90);
        values.add(50);
        values.add(40);
        values.add(10);
        values.add(9);
        values.add(5);
        values.add(4);
        values.add(1);
        return values;
    }

    public Map<Integer,String> getIntIndextoString(){
        Map<Integer,String> intIndexToString = new HashMap<>();
        intIndexToString.put(0,"M");
        intIndexToString.put(1,"CM");
        intIndexToString.put(2,"D");
        intIndexToString.put(3,"CD");
        intIndexToString.put(4,"C");
        intIndexToString.put(5,"XC");
        intIndexToString.put(6,"L");
        intIndexToString.put(7,"XL");
        intIndexToString.put(8,"X");
        intIndexToString.put(9,"IX");
        intIndexToString.put(10,"V");
        intIndexToString.put(11,"IV");
        intIndexToString.put(12,"I");
        return intIndexToString;
    }
}
