package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
 *
 * This can be optimized further without using extra O(n) time
 * by constructing map on the fly and check backwards instead of ahead.
 *
 */
public class MaximumSizeSubarraySumEqualsK {
    public Map<Integer,Integer> populateMap(int[] nums, int[] sums){
        int i = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        while(i < nums.length){
            sum += nums[i];
            sums[i] = sum;
            map.put(sum,i);
            i++;
        }
        return map;
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int[] totalSum = new int[nums.length];
        Map<Integer,Integer> map = populateMap(nums,totalSum);
        int i = -1;
        int currentSum = 0;
        int kLength = 0;
        while(i<nums.length){
            if(i!=-1)
                currentSum = totalSum[i];
            int currentKey = currentSum + k;
            Integer keyValue = map.get(currentKey);
            if(keyValue!=null && keyValue - i > kLength){
                kLength = keyValue - i;
            }
            i++;
        }
        return kLength;
    }
}
