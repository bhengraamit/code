package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 07/10/18.
 */
public class CustomSortString {

    public String customSortString(String S, String T) {
        StringBuilder finalStr = new StringBuilder();
        if(S ==null || S.isEmpty() || T == null || T.isEmpty())
            return finalStr.toString();
        Map<String,Integer> charMap = new HashMap<>();
        for(int i=0; i<T.length(); i++){
            charMap.put(T.substring(i,i+1),charMap.getOrDefault(T.substring(i,i+1),0)+1);
        }

        for(int i=0; i<S.length(); i++){
            String ch = S.substring(i,i+1);
            if(charMap.containsKey(ch)){
                finalStr.append(ch);
                if(charMap.get(ch) - 1 == 0)
                    charMap.remove(ch);
                else
                    charMap.put(ch,charMap.get(ch)-1);
            }
        }
        for(String ch:charMap.keySet()){
            int count = charMap.get(ch);
            while(count > 0){
                finalStr.append(ch);
                count--;
            }
        }
        return finalStr.toString();
    }
}
