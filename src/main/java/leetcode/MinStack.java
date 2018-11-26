package leetcode;

import java.util.Stack;

/**
 * Created by amit.bhengra on 15/09/18.
 *
 * https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {

    public class MinCount{
        int val;
        int count;
    }
    Stack<Integer> origStack = new Stack<>();
    Stack<MinCount> minStack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        origStack.push(x);
        if(minStack.empty()){
            MinCount minCount = new MinCount();
            minCount.val = x;
            minCount.count = 1;
            minStack.push(minCount);
        }else{
            MinCount minCount = minStack.peek();
            if(minCount.val == x)
                minCount.count++;
            if(minCount.val > x ){
                MinCount min = new MinCount();
                min.val = x;
                min.count = 1;
                minStack.push(min);
            }
        }

    }

    public void pop() {
        int val = origStack.pop();
        MinCount min = minStack.peek();
        if(min.val == val)
            min.count--;
        if(min.count == 0)
            minStack.pop();
    }

    public int top() {
        return origStack.peek();
    }

    public int getMin() {
        return minStack.peek().val;
    }
}
