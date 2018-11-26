package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 30/09/18.
 *
 *
 * https://leetcode.com/contest/weekly-contest-104/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class XKindDeckCards {

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck == null || deck.length == 0)
            return false;
        Map<Integer,Integer> groupCount = new HashMap<>();
        for(int i=0; i< deck.length; i++){
            Integer count = groupCount.get(deck[i]);
            if(count == null){
                count = 0;
            }
            count++;
            groupCount.put(deck[i],count);
        }
        int min = Integer.MAX_VALUE;
        for(Integer group:groupCount.keySet()){
            if(groupCount.get(group) < min)
                min = groupCount.get(group);
        }
        if(min < 2)
            return false;
        for(Integer group:groupCount.keySet()){
            int count = groupCount.get(group);
            if(count % min !=0)
                return false;
        }
        return true;
    }
}
