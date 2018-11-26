package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfAPhoneNumber {

    static Map<Character,Character[]> keyPad = new HashMap<>();

    static {
        Character[] list2 = {'a','b','c'};
        keyPad.put('2',list2);
        Character[] list3 = {'d','e','f'};
        keyPad.put('3',list3);
        Character[] list4 = {'g','h','i'};
        keyPad.put('4',list4);
        Character[] list5 = {'j','k','l'};
        keyPad.put('5',list5);
        Character[] list6 = {'m','n','o'};
        keyPad.put('6',list6);
        Character[] list7 = {'p','q','r','s'};
        keyPad.put('7',list7);
        Character[] list8 = {'t','u','v'};
        keyPad.put('8',list8);
        Character[] list9 = {'w','x','y','z'};
        keyPad.put('9',list9);
    }

    public List<String> letterCombinations(String digits) {
        List<String> totalComb = new ArrayList<>();
        if(digits == null || digits.isEmpty())
            return totalComb;
        if(digits.length() == 1){
            char ch = digits.charAt(0);
            Character[] chlist = keyPad.get(ch);
            for(Character c:chlist){
                totalComb.add(String.valueOf(c));
            }
        }else{
            char ch = digits.charAt(0);
            Character[] chlist = keyPad.get(ch);
            List<String> combinations = letterCombinations(digits.substring(1,digits.length()));
            for(Character c:chlist){
                for(String comb : combinations){
                    totalComb.add(String.valueOf(c)+comb);
                }
            }
        }
        return totalComb;
    }
}
