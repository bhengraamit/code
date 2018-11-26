package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSumRetIndex {

    public static void main(String[] args) {
        TwoSumRetIndex twoSumRetIndex = new TwoSumRetIndex();
        int[] nums = {3,2,4};
        int[] nums1 = {3,3};
        System.out.println(twoSumRetIndex.twoSum(nums,6));
        System.out.println(twoSumRetIndex.twoSum(nums1,6));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] sum= new int[2];
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        populateMap(nums,map);
        int i=0;
        while(i<nums.length){
            int find = target - nums[i];
            if (find == nums[i])
                map.get(nums[i]).remove();
            if(map.containsKey(find) && !map.get(find).isEmpty()){
                sum[0] = i;
                sum[1] = map.get(find).poll();
                return sum;
            }
            i++;
        }
        return sum;
    }

    public void populateMap(int[] nums , Map<Integer,LinkedList<Integer>> map){
        for(int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i],new LinkedList<>());
            map.get(nums[i]).add(i);
        }

    }
}
