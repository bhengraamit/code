package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 14/09/18.
 */
public class FindAllNumbersDissappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        int[] count = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        for(int j=1; j<=nums.length;j++){
            if(count[j] == 0)
                list.add(j);
        }
        return list;
    }

    /**
     *
     * Without extra space , brilliant
     *
     * public List<Integer> findDisappearedNumbers(int[] nums) {
     List<Integer> ret = new ArrayList<Integer>();

     for(int i = 0; i < nums.length; i++) {
     int val = Math.abs(nums[i]) - 1;
     if(nums[val] > 0) {
     nums[val] = -nums[val];
     }
     }

     for(int i = 0; i < nums.length; i++) {
     if(nums[i] > 0) {
     ret.add(i+1);
     }
     }
     return ret;
     }
     */
}
