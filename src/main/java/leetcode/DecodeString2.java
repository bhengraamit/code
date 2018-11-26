package leetcode;

import java.util.Stack;

/**
 * Created by amit.bhengra on 06/10/18.
 */
public class DecodeString2 {
    public static void main(String[] args) {
        DecodeString2 decodeString2 = new DecodeString2();
        decodeString2.decodeString("3[a]2[bc]");
    }

    public String decodeString(String s) {
        if(s == null || s.isEmpty())
            return "";
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length() ; i++){
            String ch = s.substring(i,i+1);
            if(ch.equals("]")){
                setStack(stack);
            }else{
                stack.push(ch);
            }
        }
        String finalString = "";
        while(!stack.empty()){
            finalString = stack.pop() + finalString;
        }
        return finalString;
    }

    public void setStack(Stack<String> stack){
        String newStr = "";
        while(!stack.peek().equals("[")){
            newStr = stack.pop() + newStr;
        }
        stack.pop();
        String numStr = "";
        while(!stack.empty() && stack.peek()!=null){
            try{
                Integer.valueOf(stack.peek());
                numStr = stack.pop() + numStr;
            }catch(Exception e){
                break;
            }
        }
        int num = Integer.valueOf(numStr);
        String finalStr = "";
        while(num > 0){
            finalStr += newStr;
            num--;
        }
        stack.push(finalStr);
    }
}
