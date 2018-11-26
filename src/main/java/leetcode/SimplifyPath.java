package leetcode;

import java.util.Stack;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String splits[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String split : splits){
            if(split.equals("..")){
                if(!stack.empty())
                    stack.pop();
            }
            else if(!split.isEmpty() && !split.equals("."))
                stack.push(split);
        }
        if(stack.empty())
            return "/";
        String finalStr = "";
        String.join("/",stack);
        while(!stack.empty())
            finalStr = "/" + stack.pop() + finalStr;
        return finalStr;
    }
}
