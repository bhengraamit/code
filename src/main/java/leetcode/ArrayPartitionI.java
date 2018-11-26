package leetcode;

import java.util.Arrays;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/array-partition-i/description/
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if(nums == null)
            return 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length;){
            sum += Math.min(nums[i],nums[i+1]);
            i = i+2;
        }
        return sum;
    }
}
