package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 *
 * https://leetcode.com/problems/monotonic-array/description/
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] array) {
        if(array==null && array.length == 0)
            return false;
        if(array.length == 1)
            return true;
        int prevNum = array[0];
        Boolean increasing = null;
        for(int i = 1; i<array.length; i++){
            if(array[i] == prevNum){
                continue;
            }
            if(array[i] > prevNum){
                if(increasing == null)
                    increasing = true;
                else if(Boolean.FALSE.equals(increasing))
                    return false;
            }
            if(array[i] < prevNum){
                if(increasing == null)
                    increasing = false;
                else if(Boolean.TRUE.equals(increasing))
                    return false;
            }

            prevNum = array[i];
        }
        return true;
    }
}
