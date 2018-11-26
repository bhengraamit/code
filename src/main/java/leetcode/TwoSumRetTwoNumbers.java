package leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by amit.bhengra on 09/09/18.
 */
public class TwoSumRetTwoNumbers {

    public int[] twoSum(int[] nums, int target) {
        int[] sum= new int[2];
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j){
            if(target == nums[i]+nums[j]){
                sum[0] = i;
                sum[1] = j;
                return sum;
            }else{
                if(target < nums[i]+nums[j])
                    j--;
                else
                    i++;
            }
        }
        return sum;
    }

    public void populateMap(int[] nums , Map<Integer,Integer> map){
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
    }
}
