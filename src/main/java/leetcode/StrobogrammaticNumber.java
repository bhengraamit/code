package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/strobogrammatic-number/description/
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.isEmpty())
            return true;

        boolean odd = num.length() % 2 == 0 ? false : true;
        if(odd){
            String mid = num.substring(num.length()/2,(num.length()/2)+1);
            if(!mid.equals("0") && !mid.equals("1") && !mid.equals("8"))
                return false;
        }

        Map<String,String> map = getMap();
        int i = (num.length()/2)-1;
        int j;
        if(odd)
            j = (num.length()/2) +1;
        else
            j = (num.length()/2);
        while(i>=0){
            String left = map.get(num.substring(i,i+1));
            String right = num.substring(j,j+1);
            if(!(left!=null && right!=null && left.equals(right)))
                return false;
            i--;j++;
        }
        return true;
    }

    public Map<String,String> getMap(){
        Map<String,String> map = new HashMap<>();
        map.put("0","0");
        map.put("1","1");
        map.put("8","8");
        map.put("6","9");
        map.put("9","6");
        return map;
    }
}
