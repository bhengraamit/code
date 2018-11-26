package leetcode;

import java.util.Stack;

/**
 * Created by amit.bhengra on 15/09/18.
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[0];
        Stack<Integer> indexStack = new Stack<>();
        int[] result = new int[nums.length];
        //forward order
        int i = 0;
        while(i<nums.length){
            if(!indexStack.empty()){
                int peek = indexStack.peek();
                while(nums[i] > nums[peek]){
                    result[peek] = nums[i];
                    indexStack.pop();
                    if(indexStack.empty())
                        break;
                    peek = indexStack.peek();
                }
                indexStack.push(i);
            }else{
                indexStack.push(i);
            }
            i++;
        }

        // second order
        int j=0;
        while(j<nums.length && !indexStack.empty() && j < indexStack.peek()){
            int peek = indexStack.peek();
            while(nums[j] > nums[peek]){
                result[peek] = nums[j];
                indexStack.pop();
                if(indexStack.empty())
                    break;
                peek = indexStack.peek();
            }
            j++;
        }
        while(!indexStack.empty()){
            result[indexStack.pop()] = -1;
        }
        return result;
    }
}
