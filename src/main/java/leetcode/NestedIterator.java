package leetcode;

/**
 * Created by amit.bhengra on 11/09/18.
 */

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class NestedIterator implements Iterator<Integer> {

    public class NestedObject{
        NestedInteger nestedInteger;
        Integer index;
    }
    Stack<NestedObject> nestedPointer = new Stack<>();
    int globalPointer = 0;
    List<NestedInteger> parent = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        parent = nestedList;
    }

    @Override
    public Integer next() {
        if(nestedPointer.isEmpty() && globalPointer < parent.size()){
            NestedInteger curr = parent.get(globalPointer);
            if(curr.isInteger()){
                globalPointer++;
                return curr.getInteger();
            }else{
                NestedInteger temp = curr;
                while(!temp.isInteger()){
                    NestedInteger zeroIndex = temp.getList().get(0);
                    if(temp.getList().size()>1){
                        NestedObject nestedObject = new NestedObject();
                        nestedObject.nestedInteger = temp;
                        nestedObject.index = 1;
                        nestedPointer.push(nestedObject);
                    }
                    temp = zeroIndex;
                }
                return temp.getInteger();
            }

        }else{
            NestedObject currObject = nestedPointer.peek();
            NestedInteger list = currObject.nestedInteger;
            int index = currObject.index;
            NestedInteger currNested = list.getList().get(index);
            if(currNested.isInteger()){
                if(index+1 <= list.getList().size()-1){
                    currObject.index = index + 1;
                }else{
                    nestedPointer.pop();
                }
                return currNested.getInteger();
            }else{
                NestedInteger temp = currNested;
                while(!temp.isInteger()){
                    NestedInteger zeroIndex = temp.getList().get(0);
                    if(temp.getList().size()>1){
                        NestedObject nestedObject = new NestedObject();
                        nestedObject.nestedInteger = temp;
                        nestedObject.index = 1;
                        nestedPointer.push(nestedObject);
                    }
                    temp = zeroIndex;
                }
                return temp.getInteger();
            }

        }
    }

    @Override
    public boolean hasNext() {
        if(nestedPointer.isEmpty()){
            if(globalPointer < parent.size())
                return true;
            else
                return false;
        }
        return true;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
