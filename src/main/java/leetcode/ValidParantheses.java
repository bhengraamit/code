package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParantheses {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0 )
            return true;

        Map<String,String> reverseMap = getReverseMap();
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            String bracket = s.substring(i,i+1);
            if(bracket.equals(")") ||bracket.equals("}") || bracket.equals("]")){
                if(stack.isEmpty() || !stack.peek().equals(reverseMap.get(bracket)))
                    return false;
                stack.pop();
            }else{
                stack.push(bracket);
            }
        }
        return stack.isEmpty();
    }

    public Map<String,String> getReverseMap(){
        Map<String,String> map = new HashMap<>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");
        return map;
    }
}
