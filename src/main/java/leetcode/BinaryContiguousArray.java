package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 16/09/18.
 *
 * https://leetcode.com/problems/contiguous-array/description/
 */
public class BinaryContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length <= 1)
            return 0;
        // min length 2
        Map<Integer,Integer> sumIndex = new HashMap<>();
        sumIndex.put(0,-1); // initial value
        int currentSum = 0;
        int retLength = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1)
                currentSum += 1;
            else
                currentSum += -1;
            if(sumIndex.containsKey(currentSum)){
                int length = i - sumIndex.get(currentSum);
                retLength = length > retLength ? length : retLength;
            }else{
                sumIndex.put(currentSum,i);
            }
        }
        return retLength;
    }
}
