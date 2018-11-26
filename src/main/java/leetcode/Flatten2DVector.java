package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/flatten-2d-vector/description/
 */
public class Flatten2DVector implements Iterator<Integer> {

    List<List<Integer>> list;
    int currentListIndex = 0;
    int currentListCount = 0;
    public Flatten2DVector(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    @Override
    public Integer next() {
        Integer  ret = list.get(currentListIndex).get(currentListCount);
        currentListCount++;
        return ret;
    }

    @Override
    public boolean hasNext() {
        if(currentListIndex < list.size()){
            if(list.get(currentListIndex) !=null && currentListCount < list.get(currentListIndex).size())
                return true;
            else{
                currentListIndex++;
                if(currentListIndex < list.size()){
                    if(list.get(currentListIndex)!=null && list.get(currentListIndex).size()>0){
                        currentListCount = 0;
                        return true;
                    }else
                        return hasNext();
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }
}
