package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 30/09/18.
 *
 * https://leetcode.com/contest/weekly-contest-104/problems/word-subsets/
 */
public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> matched = new ArrayList<>();
        Map<Character,Integer> bMap = getMinCharMap(B);
        for(String a : A){

            Map<Character,Integer> aMap = getMap(a);
            boolean match= match(aMap,bMap);
            if(match)
                matched.add(a);
        }
        return matched;
    }

    public Map<Character,Integer> getMinCharMap(String[] B){
        Map<Character,Integer> map = new HashMap<>();
        for(String b:B){
            Map<Character, Integer> map1 = getMap(b);
            for (Character ch:map1.keySet()){
                Integer count = map.get(ch);
                if(count == null)
                    count = 0;
                Integer countb = map1.get(ch);
                if(countb > count)
                    map.put(ch,countb);
            }
        }
        return map;
    }


    public boolean match(Map<Character,Integer> aMap, Map<Character,Integer> bMap){
        for(Character ch:bMap.keySet()){
            if(aMap.get(ch)==null)
                return false;
            if(aMap.get(ch) < bMap.get(ch))
                return false;
        }
        return true;
    }


    public Map<Character,Integer> getMap(String a){
        Map<Character,Integer> origMap = new HashMap<>();
        char[] chArr = a.toCharArray();
        for(char ch: chArr){
            Integer count = origMap.get(ch);
            if(count == null)
                count =0;
            count++;
            origMap.put(ch,count);
        }
        return origMap;
    }
}
