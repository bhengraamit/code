package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        if(s ==null || s.isEmpty())
            return 0;
        Map<Character,Integer> map = getMap();
        char[] chArr = s.toCharArray();
        if(s.length() == 1)
            return map.get(chArr[0]);
        int sum = map.get(chArr[0]);
        for(int i=1; i<s.length();i++){
            int curr = map.get(chArr[i]);
            int prev = map.get(chArr[i-1]);
            if(prev < curr)
                sum += curr - (2*prev);
            else
                sum += curr;
        }
        return sum;
    }

    public Map<Character,Integer> getMap(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}
